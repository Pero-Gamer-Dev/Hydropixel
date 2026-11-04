package fun.hydropixel.skyblock.auction;

import fun.hydropixel.skyblock.item.SkyblockItemData;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class AuctionItem {

    public SkyblockItemData item;
    public UUID sellerUUID;
    public String sellerName;
    public double startingBid;
    public double highestBid;
    public UUID highestBidder;
    public boolean isBin;
    public long endTime;

}
