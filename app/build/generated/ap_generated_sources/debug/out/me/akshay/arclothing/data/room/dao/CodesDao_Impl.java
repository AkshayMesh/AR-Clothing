package me.akshay.arclothing.data.room.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.akshay.arclothing.common.models.ProductInventory;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CodesDao_Impl implements CodesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ProductInventory> __insertionAdapterOfProductInventory;

  private final EntityInsertionAdapter<ProductInventory> __insertionAdapterOfProductInventory_1;

  private final SharedSQLiteStatement __preparedStmtOfNukeTable;

  private final SharedSQLiteStatement __preparedStmtOfKillProduct;

  private final SharedSQLiteStatement __preparedStmtOfChange;

  public CodesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProductInventory = new EntityInsertionAdapter<ProductInventory>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Cart` (`id`,`product_id`,`available_qty`,`productName`,`productCode`,`prodGST`,`price`,`imageUri`,`newPrice`,`currentQuantity`,`userID`,`isTriable`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductInventory value) {
        stmt.bindLong(1, value.id);
        stmt.bindLong(2, value.product_id);
        stmt.bindLong(3, value.available_qty);
        if (value.productName == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.productName);
        }
        if (value.productCode == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.productCode);
        }
        stmt.bindDouble(6, value.prodGST);
        stmt.bindDouble(7, value.price);
        if (value.imageUri == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.imageUri);
        }
        stmt.bindDouble(9, value.newPrice);
        stmt.bindLong(10, value.currentQuantity);
        if (value.userID == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.userID);
        }
        stmt.bindLong(12, value.isTriable);
      }
    };
    this.__insertionAdapterOfProductInventory_1 = new EntityInsertionAdapter<ProductInventory>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Cart` (`id`,`product_id`,`available_qty`,`productName`,`productCode`,`prodGST`,`price`,`imageUri`,`newPrice`,`currentQuantity`,`userID`,`isTriable`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductInventory value) {
        stmt.bindLong(1, value.id);
        stmt.bindLong(2, value.product_id);
        stmt.bindLong(3, value.available_qty);
        if (value.productName == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.productName);
        }
        if (value.productCode == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.productCode);
        }
        stmt.bindDouble(6, value.prodGST);
        stmt.bindDouble(7, value.price);
        if (value.imageUri == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.imageUri);
        }
        stmt.bindDouble(9, value.newPrice);
        stmt.bindLong(10, value.currentQuantity);
        if (value.userID == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.userID);
        }
        stmt.bindLong(12, value.isTriable);
      }
    };
    this.__preparedStmtOfNukeTable = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Cart";
        return _query;
      }
    };
    this.__preparedStmtOfKillProduct = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Cart WHERE id = ? and productCode =?";
        return _query;
      }
    };
    this.__preparedStmtOfChange = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Cart SET currentQuantity = ? WHERE id =?";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final ProductInventory... codes) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProductInventory.insert(codes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long[] insertBulk(final List<ProductInventory> entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long[] _result = __insertionAdapterOfProductInventory_1.insertAndReturnIdsArray(entity);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void nukeTable() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfNukeTable.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfNukeTable.release(_stmt);
    }
  }

  @Override
  public void killProduct(final int id, final String code) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfKillProduct.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    _argIndex = 2;
    if (code == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, code);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfKillProduct.release(_stmt);
    }
  }

  @Override
  public void change(final int quantity, final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfChange.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, quantity);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfChange.release(_stmt);
    }
  }

  @Override
  public List<ProductInventory> getScrollableCodes() {
    final String _sql = "SELECT * FROM Cart";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "product_id");
      final int _cursorIndexOfAvailableQty = CursorUtil.getColumnIndexOrThrow(_cursor, "available_qty");
      final int _cursorIndexOfProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "productName");
      final int _cursorIndexOfProductCode = CursorUtil.getColumnIndexOrThrow(_cursor, "productCode");
      final int _cursorIndexOfProdGST = CursorUtil.getColumnIndexOrThrow(_cursor, "prodGST");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUri");
      final int _cursorIndexOfNewPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "newPrice");
      final int _cursorIndexOfCurrentQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "currentQuantity");
      final int _cursorIndexOfUserID = CursorUtil.getColumnIndexOrThrow(_cursor, "userID");
      final int _cursorIndexOfIsTriable = CursorUtil.getColumnIndexOrThrow(_cursor, "isTriable");
      final List<ProductInventory> _result = new ArrayList<ProductInventory>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ProductInventory _item;
        _item = new ProductInventory();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _item.product_id = _cursor.getInt(_cursorIndexOfProductId);
        _item.available_qty = _cursor.getInt(_cursorIndexOfAvailableQty);
        if (_cursor.isNull(_cursorIndexOfProductName)) {
          _item.productName = null;
        } else {
          _item.productName = _cursor.getString(_cursorIndexOfProductName);
        }
        if (_cursor.isNull(_cursorIndexOfProductCode)) {
          _item.productCode = null;
        } else {
          _item.productCode = _cursor.getString(_cursorIndexOfProductCode);
        }
        _item.prodGST = _cursor.getFloat(_cursorIndexOfProdGST);
        _item.price = _cursor.getFloat(_cursorIndexOfPrice);
        if (_cursor.isNull(_cursorIndexOfImageUri)) {
          _item.imageUri = null;
        } else {
          _item.imageUri = _cursor.getString(_cursorIndexOfImageUri);
        }
        _item.newPrice = _cursor.getFloat(_cursorIndexOfNewPrice);
        _item.currentQuantity = _cursor.getInt(_cursorIndexOfCurrentQuantity);
        if (_cursor.isNull(_cursorIndexOfUserID)) {
          _item.userID = null;
        } else {
          _item.userID = _cursor.getString(_cursorIndexOfUserID);
        }
        _item.isTriable = _cursor.getInt(_cursorIndexOfIsTriable);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getRowCount() {
    final String _sql = "SELECT COUNT(id) FROM Cart";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
