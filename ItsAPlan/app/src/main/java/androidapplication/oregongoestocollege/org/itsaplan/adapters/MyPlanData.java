package androidapplication.oregongoestocollege.org.itsaplan.adapters;

/**
 * Created by Bikram Maharjan on 11/10/17.
 */

public class MyPlanData {
    private int imageId;
    private String myPlanListItem;

    public MyPlanData(int imageId, String myPlanListItem) {
        this.imageId = imageId;
        this.myPlanListItem = myPlanListItem;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getMyPlanListItem() {
        return myPlanListItem;
    }

    public void setMyPlanListItem(String myPlanListItem) {
        this.myPlanListItem = myPlanListItem;
    }
}
