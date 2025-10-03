package com.floofyplasma.sltest.achievement;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.achievement.Achievement;
import net.minecraft.item.Item;
import com.floofyplasma.sltest.item.ItemListener;
import com.floofyplasma.stationapi.api.client.gui.screen.achievement.AchievementPage;
import com.floofyplasma.stationapi.api.event.achievement.AchievementRegisterEvent;

import static com.floofyplasma.sltest.SLTest.NAMESPACE;

public class AchievementListener {
    public static AchievementPage testAchievementPage;
    public static Achievement
            testAchievement,
            testAchievementChild;

    @EventListener
    public void registerAchievements(AchievementRegisterEvent event) {
        testAchievementPage = new AchievementPageTest(NAMESPACE.id("testPage"));
        testAchievement = new Achievement(69696969, "sltest.testAchievement", 0, 0, ItemListener.testItem, null);
        testAchievementChild = new Achievement(69696970, "sltest.testAchievementChild", 0, 2, Item.GOLDEN_APPLE, testAchievement);
        event.achievements.add(testAchievement);
        event.achievements.add(testAchievementChild);
        testAchievementPage.addAchievements(testAchievement, testAchievementChild);
    }
}
