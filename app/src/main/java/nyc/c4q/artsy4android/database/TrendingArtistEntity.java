package nyc.c4q.artsy4android.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class TrendingArtistEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;


    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "artistID")
    public String artistID;

    @ColumnInfo(name = "imgURL")
    public String imgURL;

    @ColumnInfo(name = "lifeSpan")
    public String lifeSpan;

    @ColumnInfo(name = "nationality")
    public String nationality;

    @ColumnInfo(name = "Birthplace")
    public String birthplace;
}
