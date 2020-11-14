package com.gildedrose;

import java.util.Arrays;

class GildedRose {

    Item[] items;

    /**
     * Do not change the arguments of the constructor in any way
     *
     * @param items Array of Items
     */
    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * Want to make this refactoring more interesting? Add one or more challenges:
     * 1. Speed Challenge: Do not use your mouse at all
     * 2. Surgeon Challenge: No breaking changes. Only baby steps are allowed and tests must pass after each step.
     * 3. Focus Challenge: Explain what your goal is and why this is good before doing it.
     * 4. Precision Challenge: You are only allowed to speak, someone else has to do it.
     * 5. Bonus Challenge: Refactor in a way that you do not use a single if statement
     */
    public void updateQuality() {
        Arrays.stream(items).forEach(this::updateItem);
    }

    private void updateItem(Item item) {

        if (item.name.equals("Sulfuras, Hand of Ragnaros"))
            return;

        item.sellIn = item.sellIn - 1;
        boolean isSellInNeg = item.sellIn < 0;
        item.quality += switch (item.name) {
            case "Aged Brie" -> (isSellInNeg ? 2 : 1);
            case "Backstage passes to a TAFKAL80ETC concert" -> (isSellInNeg ? -item.quality : updateItemQualityBackstage(item));
            default -> (isSellInNeg ? -2 : -1);
        };

        item.quality = Math.min(50, Math.max(item.quality, 0));
    }

    private int updateItemQualityBackstage(Item item) {
        return switch (item.sellIn){
            case 9,8,7,6,5 -> 2;
            case 4,3,2,1,0 -> 3;
            default -> 1;
        };
    }
}