package me.akshay.arclothing.data.room;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.akshay.arclothing.data.room.dao.CodesDao;
import me.akshay.arclothing.data.room.dao.CodesDao_Impl;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FoldDatabase_Impl extends FoldDatabase {
  private volatile CodesDao _codesDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Cart` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `product_id` INTEGER NOT NULL, `available_qty` INTEGER NOT NULL, `productName` TEXT, `productCode` TEXT, `prodGST` REAL NOT NULL, `price` REAL NOT NULL, `imageUri` TEXT, `newPrice` REAL NOT NULL, `currentQuantity` INTEGER NOT NULL, `userID` TEXT, `isTriable` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '2b89d8f02cc6845c6790628c2088a8e2')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Cart`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCart = new HashMap<String, TableInfo.Column>(12);
        _columnsCart.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("product_id", new TableInfo.Column("product_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("available_qty", new TableInfo.Column("available_qty", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("productName", new TableInfo.Column("productName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("productCode", new TableInfo.Column("productCode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("prodGST", new TableInfo.Column("prodGST", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("price", new TableInfo.Column("price", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("imageUri", new TableInfo.Column("imageUri", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("newPrice", new TableInfo.Column("newPrice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("currentQuantity", new TableInfo.Column("currentQuantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("userID", new TableInfo.Column("userID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("isTriable", new TableInfo.Column("isTriable", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCart = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCart = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCart = new TableInfo("Cart", _columnsCart, _foreignKeysCart, _indicesCart);
        final TableInfo _existingCart = TableInfo.read(_db, "Cart");
        if (! _infoCart.equals(_existingCart)) {
          return new RoomOpenHelper.ValidationResult(false, "Cart(me.akshay.arclothing.common.models.ProductInventory).\n"
                  + " Expected:\n" + _infoCart + "\n"
                  + " Found:\n" + _existingCart);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "2b89d8f02cc6845c6790628c2088a8e2", "c63cc1bab8aa8e41a6433eb974c08443");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Cart");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Cart`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CodesDao.class, CodesDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public CodesDao codeDao() {
    if (_codesDao != null) {
      return _codesDao;
    } else {
      synchronized(this) {
        if(_codesDao == null) {
          _codesDao = new CodesDao_Impl(this);
        }
        return _codesDao;
      }
    }
  }
}
