package com.cookandroid.aahhrraa;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class DataLoginAdapter {

    protected static final String TAG = "DataLoginAdapter";

    protected static final String TABLE_NAME = "DEMO_SQLITE";

    private final Context mContext;
    private SQLiteDatabase mDb;
    private DataBaseHelper mDbHelper;

    public DataLoginAdapter(Context context)
    {
        this.mContext = context;
        mDbHelper = new DataBaseHelper(mContext);
    }

    public DataLoginAdapter createDatabase() throws SQLException
    {
        try
        {
            mDbHelper.createDataBase();
        }
        catch (IOException mIOException)
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public DataLoginAdapter open() throws SQLException
    {
        try
        {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "open >>"+ mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }

    public ArrayList getTableData()
    {
        try
        {
            String sql ="SELECT * FROM " + TABLE_NAME;

            ArrayList logininfo = new ArrayList();

            lloogin iinnffo = null;

            Cursor mCur = mDb.rawQuery(sql, null);
            if (mCur!=null)
            {
                // 칼럼의 마지막까지
                while( mCur.moveToNext() ) {

                    iinnffo = new lloogin();

                    iinnffo.setLloogin_name(mCur.getString(0));
                    iinnffo.setLloogin_address(mCur.getString(1));
                    iinnffo.setLloogin_phone(mCur.getString(2));

                    // 리스트에 넣기
                    logininfo.add(iinnffo);
                }

            }
            return logininfo;
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "getTestData >>"+ mSQLException.toString());
            throw mSQLException;
        }
    }
}

