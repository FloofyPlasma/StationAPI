package com.floofyplasma.stationapi.api.state.property;

import com.google.common.base.MoreObjects;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.floofyplasma.stationapi.api.state.State;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class Property<T extends Comparable<T>> {
   private final Class<T> type;
   private final String name;
   private Integer hashCodeCache;
   @SuppressWarnings("FieldCanBeLocal")
   private final Codec<T> codec;
   private final Codec<Property.Value<T>> valueCodec;

   protected Property(String name, Class<T> type) {
      this.codec = Codec.STRING.comapFlatMap((value) -> this.parse(value).map(DataResult::success).orElseGet(() -> DataResult.error(() -> "Unable to read property: " + this + " with value: " + value)), this::name);
      this.valueCodec = this.codec.xmap(this::createValue, Property.Value::getValue);
      this.type = type;
      this.name = name;
   }

   public Property.Value<T> createValue(T value) {
      return new Property.Value<>(this, value);
   }

   public Property.Value<T> createValue(State<?, ?> state) {
      return new Property.Value<>(this, state.get(this));
   }

   public Stream<Property.Value<T>> stream() {
      return this.getValues().stream().map(this::createValue);
   }

   public Codec<Property.Value<T>> getValueCodec() {
      return this.valueCodec;
   }

   public String getName() {
      return this.name;
   }

   public Class<T> getType() {
      return this.type;
   }

   /**
    * Returns all possible values the property can take.
    */
   public abstract Collection<T> getValues();

   public abstract String name(T value);

   public abstract Optional<T> parse(String name);

   @Override
   public String toString() {
      return MoreObjects.toStringHelper(this).add("name", this.name).add("clazz", this.type).add("values", this.getValues()).toString();
   }

   @Override
   public boolean equals(Object object) {
      return this == object || object instanceof Property<?> property && this.type.equals(property.type) && this.name.equals(property.name);
   }

   @Override
   public final int hashCode() {
      if (this.hashCodeCache == null) {
         this.hashCodeCache = this.computeHashCode();
      }

      return this.hashCodeCache;
   }

   public int computeHashCode() {
      return 31 * this.type.hashCode() + this.name.hashCode();
   }

   @SuppressWarnings("ClassCanBeRecord")
   public static final class Value<T extends Comparable<T>> {
      private final Property<T> property;
      private final T value;

      private Value(Property<T> property, T value) {
         if (!property.getValues().contains(value)) {
            throw new IllegalArgumentException("Value " + value + " does not belong to property " + property);
         } else {
            this.property = property;
            this.value = value;
         }
      }

      public Property<T> getProperty() {
         return this.property;
      }

      public T getValue() {
         return this.value;
      }

      public String toString() {
         return this.property.getName() + "=" + this.property.name(this.value);
      }

      @Override
      public boolean equals(Object object) {
         return this == object || object instanceof Value<?> value && this.property == value.property && this.value.equals(value.value);
      }

      @Override
      public int hashCode() {
         int i = this.property.hashCode();
         i = 31 * i + this.value.hashCode();
         return i;
      }
   }
}
