package androidapplication.oregongoestocollege.org.itsaplan.blocks;

/**
 * Created by Bikram Maharjan on 10/27/17.
 */

public class SingleBlock {
    private int mSingleBlockId;
    private String mBlockTitle;
    private Stage[] mStages;

    public int getSingleBlockId() {
        return mSingleBlockId;
    }

    public void setSingleBlockId(int singleBlockId) {
        mSingleBlockId = singleBlockId;
    }

    public String getBlockTitle() {
        return mBlockTitle;
    }

    public void setBlockTitle(String blockTitle) {
        mBlockTitle = blockTitle;
    }

    public Stage[] getStages() {
        return mStages;
    }

    public void setStages(Stage[] stages) {
        mStages = stages;
    }
};
