package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseUpdatedTest {

    @Test
    @Disabled("Waiting for Update")
    void conjuredItemsQualityChangesTwiceAsFast() {
        Item[] items = new Item[]{new Item("Conjured foo", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(9);
        assertThat(app.items[1].quality).isEqualTo(8);
    }

    @Test
    @Disabled("Waiting for Update")
    void conjuredItemsQualityChangesTwiceAsFast_2() {
        Item[] items = new Item[]{new Item("Conjured Potion", 10, 10),
                new Item("Normal Potion", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(9);
        assertThat(app.items[1].quality).isEqualTo(8);

        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(8);
        assertThat(app.items[1].quality).isEqualTo(6);

        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(7);
        assertThat(app.items[1].quality).isEqualTo(4);

        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(6);
        assertThat(app.items[1].quality).isEqualTo(2);

        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(5);
        assertThat(app.items[1].quality).isEqualTo(0);

        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(4);
        assertThat(app.items[1].quality).isEqualTo(0);

    }
}
