import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

/**
 * Created by caoqingguang on 2017/7/3.
 */
@Data
@DatabaseTable(tableName = "mycell")
public class MyCell {
    @DatabaseField(columnName = "id",id=true)
    private Integer id;
    @DatabaseField(columnName = "cname")
    private String cname;
}
