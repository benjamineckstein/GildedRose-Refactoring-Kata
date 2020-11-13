package com.gildedrose;

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
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        item.quality =
                switch (item.name) {
                    case "Aged Brie" -> item.quality + 1;
                    case "Backstage passes to a TAFKAL80ETC concert" -> item.quality + updateItemQualityBackstage(item);
                    case "Sulfuras, Hand of Ragnaros" -> item.quality;
                    default -> item.quality - 1;
                };

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            item.quality = switch (item.name) {
                case "Aged Brie" -> item.quality +1;
                case "Backstage passes to a TAFKAL80ETC concert" -> 0;
                case "Sulfuras, Hand of Ragnaros" -> item.quality;
                default -> item.quality - 1;
            };
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = Math.max(item.quality, 0);
            item.quality = Math.min(50, item.quality);
        }
    }

    private int updateItemQualityBackstage(Item item) {
        int result = 1;
        if (item.sellIn < 6) {
            result = 3;
        } else if (item.sellIn < 11) {
            result = 2;
        }
        return result;
    }

}