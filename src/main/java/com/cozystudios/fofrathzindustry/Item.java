package com.cozystudios.fofrathzindustry;

public class Item
{
    public ItemType getItemType() {
        return _itemType;
    }

    ItemType _itemType;
    public Item(ItemType itemType)
    {
        _itemType = itemType;
    }

    public static ItemType TileToItemType(TileType tile)
    {
        switch (tile) {
            case Copper -> {return ItemType.Copper;}
            case Coal -> {return ItemType.Coal;}
            default -> {return null;}
        }
    }

    public enum ItemType
    {
        None,
        //Stone,
        Copper,
        Iron,
        IronIngot,
        Coal,
        CopperIngot,
        CopperWire,
        Steel
    }
}
