package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextBasedTest {

    @Test
    void textBasedTest() {
        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        int days = 5;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < days; i++) {
            output.append("-------- day ").append(i).append(" --------\n");
            output.append("name, sellIn, quality\n");
            for (Item item : items) {
                output.append(item).append("\n");
            }
            output.append("\n");
            app.updateQuality();
        }

        assertThat(output.toString()).isEqualTo(getStringOutput());
    }

    private String getStringOutput() {
//Textblocks require JAVA 15
        return """
                -------- day 0 --------
                name, sellIn, quality
                +5 Dexterity Vest, 10, 20
                Aged Brie, 2, 0
                Elixir of the Mongoose, 5, 7
                Sulfuras, Hand of Ragnaros, 0, 80
                Sulfuras, Hand of Ragnaros, -1, 80
                Backstage passes to a TAFKAL80ETC concert, 15, 20
                Backstage passes to a TAFKAL80ETC concert, 10, 49
                Backstage passes to a TAFKAL80ETC concert, 5, 49
                Conjured Mana Cake, 3, 6

                -------- day 1 --------
                name, sellIn, quality
                +5 Dexterity Vest, 9, 19
                Aged Brie, 1, 1
                Elixir of the Mongoose, 4, 6
                Sulfuras, Hand of Ragnaros, 0, 80
                Sulfuras, Hand of Ragnaros, -1, 80
                Backstage passes to a TAFKAL80ETC concert, 14, 21
                Backstage passes to a TAFKAL80ETC concert, 9, 50
                Backstage passes to a TAFKAL80ETC concert, 4, 50
                Conjured Mana Cake, 2, 5

                -------- day 2 --------
                name, sellIn, quality
                +5 Dexterity Vest, 8, 18
                Aged Brie, 0, 2
                Elixir of the Mongoose, 3, 5
                Sulfuras, Hand of Ragnaros, 0, 80
                Sulfuras, Hand of Ragnaros, -1, 80
                Backstage passes to a TAFKAL80ETC concert, 13, 22
                Backstage passes to a TAFKAL80ETC concert, 8, 50
                Backstage passes to a TAFKAL80ETC concert, 3, 50
                Conjured Mana Cake, 1, 4

                -------- day 3 --------
                name, sellIn, quality
                +5 Dexterity Vest, 7, 17
                Aged Brie, -1, 4
                Elixir of the Mongoose, 2, 4
                Sulfuras, Hand of Ragnaros, 0, 80
                Sulfuras, Hand of Ragnaros, -1, 80
                Backstage passes to a TAFKAL80ETC concert, 12, 23
                Backstage passes to a TAFKAL80ETC concert, 7, 50
                Backstage passes to a TAFKAL80ETC concert, 2, 50
                Conjured Mana Cake, 0, 3

                -------- day 4 --------
                name, sellIn, quality
                +5 Dexterity Vest, 6, 16
                Aged Brie, -2, 6
                Elixir of the Mongoose, 1, 3
                Sulfuras, Hand of Ragnaros, 0, 80
                Sulfuras, Hand of Ragnaros, -1, 80
                Backstage passes to a TAFKAL80ETC concert, 11, 24
                Backstage passes to a TAFKAL80ETC concert, 6, 50
                Backstage passes to a TAFKAL80ETC concert, 1, 50
                Conjured Mana Cake, -1, 1

                """;
    }
}
