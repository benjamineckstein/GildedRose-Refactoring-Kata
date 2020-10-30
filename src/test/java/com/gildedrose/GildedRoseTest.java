package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void itemNameShouldRemain() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("foo");
    }

    @Test
    void qualityShouldDegrade() {
        Item[] items = new Item[]{new Item("foo", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(9);
    }

    @Test
    void sellInShouldDegrade() {
        Item[] items = new Item[]{new Item("foo", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(9);
    }

    @Test
    void qualityShouldDegradeSecondTime() {
        Item[] items = new Item[]{new Item("foo", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(8);
        assertThat(app.items[0].sellIn).isEqualTo(8);
    }

    @Test
    void qualityShouldDegradeTwiceWhenSellInHasPassed() {
        Item[] items = new Item[]{new Item("foo", 0, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void qualityShouldNeverBeNegative() {
        Item[] items = new Item[]{new Item("foo", 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }


    @Test
    void qualityIncreaseOverTimeForAgedBrie() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(11);
    }

    @Test
    void qualityShouldNotBeOver50() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(9);
        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void sulfurasShouldNotDecreaseInSellinOrQuality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 30, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(30);
        assertThat(app.items[0].quality).isEqualTo(80);
    }

    @Test
    void backstagePassesQualityShouldIncreaseBy2() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(9);
        assertThat(app.items[0].quality).isEqualTo(2);
    }

    @Test
    void backstagePassesQualityShouldIncreaseBy2_2() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(5);
        assertThat(app.items[0].quality).isEqualTo(12);
    }

    @Test
    void backstagePassesQualityShouldIncreaseBy3() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(4);
        assertThat(app.items[0].quality).isEqualTo(3);
    }

    @Test
    void backstagePassesQualityShouldIncreaseBy3_2() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(0);
        assertThat(app.items[0].quality).isEqualTo(8);
    }

    @Test
    void backstagePassesQualityShouldDropTo0() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(-1);
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void allItemsShouldBeProcessed() {
        Item[] items = new Item[]{
                new Item("foo", 0, 0),
                new Item("foo", 1, 4),
                new Item("foo", 2, 5),
                new Item("foo", 3, 6)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).hasSize(4);
        assertThat(app.items).contains(
                new Item("foo", -1, 0),
                new Item("foo", 0, 3),
                new Item("foo", 1, 4),
                new Item("foo", 2, 5)

        );

    }


}
