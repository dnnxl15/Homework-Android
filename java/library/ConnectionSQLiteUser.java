package library;

/**
 * Created by dnnxl on 21/2/2018.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import library.IConstant;

public class ConnectionSQLiteUser extends SQLiteOpenHelper implements IConstant {

    /**
     * Method constructor
     * Author: Esteban Coto Alfaro
     * Description: Method constructor.
     * Last modification: 22/02/18
     * @param pContext
     * @param pName
     * @param pFactory
     * @param pVersion
     */
    public ConnectionSQLiteUser(Context pContext, String pName, SQLiteDatabase.CursorFactory pFactory, int pVersion) {
        super(pContext, pName, pFactory, pVersion);
    }

    /**
     * Method onCreate
     * Author: Esteban Coto Alfaro
     * Description: Method on create.
     * Last modification: 22/02/18
     * @param pDataBase
     */
    @Override
    public void onCreate(SQLiteDatabase pDataBase) {
        pDataBase.execSQL(IConstant.CREATE_TABLE_USER);
    }

    /**
     * Method onUpgrade
     * Author: Esteban Coto Alfaro
     * Description: Method on upgrade.
     * Last modification: 22/02/18
     * @param pDataBase
     * @param pOldVersion
     * @param pNewVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase pDataBase, int pOldVersion, int pNewVersion) {
        pDataBase.execSQL("DROP TABLE IF EXISTS " + IConstant.TABLE_USER);
        onCreate(pDataBase);
    }
}
