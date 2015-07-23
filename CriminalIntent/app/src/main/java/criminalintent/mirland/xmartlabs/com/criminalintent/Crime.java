package criminalintent.mirland.xmartlabs.com.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by mirland on 21/07/15.
 */
public class Crime {
    private UUID mId;
    private String mTitle;

    /*Date to the crime ocurred*/
    private Date mDate;
    private boolean mSolved;


    public Crime() {
        // Generate unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    @Override
    public String toString(){
        return this.getTitle();
    }
}
