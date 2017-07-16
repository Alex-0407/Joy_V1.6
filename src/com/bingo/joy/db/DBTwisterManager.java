package com.bingo.joy.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.bingo.joy.model.Twister;
import com.bingo.joy.model.Twister;
import com.bingo.util.HalfAngleToAngleUtil;

public class DBTwisterManager {
	private DBHelper dbHelper = null;
	private SQLiteDatabase sdDatabase = null;
	private final String TABLE_NAME = "twister";

	public DBTwisterManager(Context context) {
		dbHelper = new DBHelper(context);
		sdDatabase = dbHelper.getWritableDatabase();
		Log.i("test", "DBProverbManager");
	}
	
	// ����twisterDes����TwisterId
			public List<Twister> findTwisterIdByDes(String twisterDes) {
				Cursor cursor;
				List<Twister> list = new ArrayList<Twister>();

				System.out.println("=====twisterDes====" + twisterDes);
				if (!"".equals(twisterDes)) {
					cursor = sdDatabase.query(TABLE_NAME, null, "twisterDes=?",
							new String[] { String.valueOf(twisterDes) }, null, null,
							null);
				} else {
					cursor = sdDatabase.query(TABLE_NAME, null, null, null, null, null,
							null);
				}

				if (cursor.getCount() > 0) {
					for (int i = 0; i < cursor.getCount(); i++) {
						cursor.moveToNext();
						Twister twister = new Twister();
						twister.setTwisterId(Integer.parseInt(cursor.getString(0)));
						twister.setTwisterDes(cursor.getString(1));
						twister.setTwisterKey(cursor.getString(2));
						twister.setTwisterKind(cursor.getString(3));
						twister.setTwisterRemark(cursor.getString(4));
						list.add(twister);

						// System.out.println("=====list====="+list.toString());
					}
					return list;
				} else {
					return null;
				}

			}
		
		// ����Remark����
			public List<Twister> findTwistersByRemark(String kind) {
				Cursor cursor;
				List<Twister> list = new ArrayList<Twister>();

				System.out.println("=====remark====" + kind);
				if (!"".equals(kind)) {
					cursor = sdDatabase
							.query(TABLE_NAME,
									null,
									"twisterRemark=? and twisterKind=?",
									new String[] { String.valueOf("�"),
											String.valueOf(kind) }, null, null, null);
				} else {
					cursor = sdDatabase.query(TABLE_NAME, null, "twisterRemark=?",
							new String[] { String.valueOf("�") }, null, null, null);
				}

				if (cursor.getCount() > 0) {
					for (int i = 0; i < cursor.getCount(); i++) {
						cursor.moveToNext();
						Twister twister = new Twister();
						twister.setTwisterId(Integer.parseInt(cursor.getString(0)));
						twister.setTwisterDes(cursor.getString(1));
						twister.setTwisterKey(cursor.getString(2));
						twister.setTwisterKind(cursor.getString(3));
						twister.setTwisterRemark(cursor.getString(4));
						list.add(twister);

						// System.out.println("=====list====="+list.toString());
					}
					return list;
				} else {
					return null;
				}

			}
			
			// �޸�
			public boolean update(Twister twister) {
				ContentValues cValues = new ContentValues();

				// cValues.put("twisterId", twister.getTwisterId());
				// cValues.put("twisterDes", twister.getTwisterDes());
				// cValues.put("twisterKey", twister.getTwisterKey());
				// cValues.put("twisterKind", twister.getTwisterKind());
				cValues.put("twisterRemark", twister.getTwisterRemark());

				int i = sdDatabase.update(TABLE_NAME, cValues, "twisterId=?",
						new String[] { String.valueOf(twister.getTwisterId()) });

				if (i > 0) {
					return true;
				} else {
					return false;
				}
			}

	// ����ID����
	public Twister findTwisterById(int id) {
		Cursor cursor = sdDatabase.query(TABLE_NAME, null, "twisterId=?",
				new String[] { String.valueOf(id) }, null, null, null);
		Twister twister = new Twister();
		if (cursor.getCount() > 0) {
			cursor.moveToNext();
			twister.setTwisterId(Integer.parseInt(cursor.getString(0)));
			twister.setTwisterDes(HalfAngleToAngleUtil.ToDBC(cursor
					.getString(1)));
			twister.setTwisterKey(cursor.getString(2));
			twister.setTwisterKind(cursor.getString(3));
			twister.setTwisterRemark(cursor.getString(4));
			return twister;
		} else {
			return null;
		}

	}

	// ����kind����
	public List<Twister> findTwistersByKind(String kind) {
		Cursor cursor;
		List<Twister> list = new ArrayList<Twister>();

		System.out.println("=====kind====" + kind);
		if (!"".equals(kind)) {
			cursor = sdDatabase.query(TABLE_NAME, null, "twisterKind=?",
					new String[] { String.valueOf(kind) }, null, null, null);
		} else {
			cursor = sdDatabase.query(TABLE_NAME, null, null, null, null, null,
					null);
		}

		if (cursor.getCount() > 0) {
			for (int i = 0; i < cursor.getCount(); i++) {
				cursor.moveToNext();
				Twister twister = new Twister();
				twister.setTwisterId(Integer.parseInt(cursor.getString(0)));
				twister.setTwisterDes(cursor.getString(1));
				twister.setTwisterKey(cursor.getString(2));
				twister.setTwisterKind(cursor.getString(3));
				twister.setTwisterRemark(cursor.getString(4));
				list.add(twister);

				// System.out.println("=====list====="+list.toString());
			}
			return list;
		} else {
			return null;
		}

	}

	// ����ID����
	public List<Twister> findTwistersById(int id) {
		Cursor cursor;
		List<Twister> list = new ArrayList<Twister>();

		System.out.println("=====id====" + id);
		if (!"".equals(id)) {
			cursor = sdDatabase.query(TABLE_NAME, null, "twisterId=?",
					new String[] { String.valueOf(id) }, null, null, null);
		} else {
			cursor = sdDatabase.query(TABLE_NAME, null, null, null, null, null,
					null);
		}

		Twister twister = new Twister();
		if (cursor.getCount() > 0) {
			for (int i = 0; i < cursor.getCount(); i++) {
				cursor.moveToNext();
				twister.setTwisterId(Integer.parseInt(cursor.getString(0)));
				twister.setTwisterDes(cursor.getString(1));
				twister.setTwisterKey(cursor.getString(2));
				twister.setTwisterKind(cursor.getString(3));
				twister.setTwisterRemark(cursor.getString(4));
				list.add(twister);
			}
			return list;
		} else {
			return null;
		}

	}

	// ����kind����
	public Twister findTwisterByKindAndId(String kind, int id) {
		Cursor cursor;
		System.out.println("=====kind====" + kind);
		if (!"".equals(kind)) {
			cursor = sdDatabase.query(TABLE_NAME, null,
					"twisterKind=? and twisterId=?",
					new String[] { String.valueOf(kind), String.valueOf(id) },
					null, null, null);
		} else {
			cursor = sdDatabase.query(TABLE_NAME, null, "twisterId=?",
					new String[] { String.valueOf(id) }, null, null, null);
		}

		Twister twister = new Twister();
		if (cursor.getCount() > 0) {
			cursor.moveToNext();
			twister.setTwisterId(Integer.parseInt(cursor.getString(0)));
			twister.setTwisterDes(cursor.getString(1));
			twister.setTwisterKey(cursor.getString(2));
			twister.setTwisterKind(cursor.getString(3));
			twister.setTwisterRemark(cursor.getString(4));
			System.out.println("=====twister.settwisterDes===="
					+ cursor.getString(1));
			System.out.println("=====twister.settwisterKey===="
					+ cursor.getString(2));
			return twister;
		} else {
			return null;
		}

	}

	// ����kind���ҷ��ص�������
	public int findTwisterCountByKind(String kind) {
		Cursor cursor;
		System.out.println("=====kind====" + kind);
		if (!"".equals(kind)) {
			cursor = sdDatabase.query(TABLE_NAME, null, "twisterKind=?",
					new String[] { String.valueOf(kind) }, null, null, null);
		} else {
			cursor = sdDatabase.query(TABLE_NAME, null, null, null, null, null,
					null);
		}

		if (cursor.getCount() > 0) {
			return cursor.getCount();
		} else {
			return 0;
		}

	}

	// ����kind���ҷ��ص�������
	public int findTwisterLastIdByKind(String kind) {
		Cursor cursor;
		System.out.println("=====kind====" + kind);
		if (!"".equals(kind)) {
			cursor = sdDatabase.query(TABLE_NAME,
					new String[] { String.valueOf("twisterId") },
					"twisterKind=?", new String[] { String.valueOf(kind) },
					null, null, null);
		} else {
			cursor = sdDatabase.query(TABLE_NAME,
					new String[] { String.valueOf("twisterId") }, null, null,
					null, null, null);
		}

		if (cursor.getCount() > 0) {
			cursor.moveToNext();
			System.out.println("======twisterId====="
					+ cursor.getColumnIndex("twisterId"));
			return cursor.getCount();
		} else {
			return 0;
		}

	}

	// �������ȡ������ϸ���б�
	public List<HashMap<String, String>> queryAllByKind(String rKind) {
		Cursor cursor = sdDatabase.query(TABLE_NAME, null, "twisterKind=?",
				new String[] { rKind }, null, null, null);
		List<HashMap<String, String>> resultList = new ArrayList<HashMap<String, String>>();
		while (cursor.moveToNext()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("twisterId", cursor.getString(0));
			map.put("twisterDes", cursor.getString(1));
			map.put("twisterKey", cursor.getString(2));
			map.put("twisterKind", cursor.getString(3));
			map.put("twisterRemark", cursor.getString(4));

			resultList.add(map);
		}

		return resultList;
	}

	public void insert(Twister twister) {
		ContentValues cValues = new ContentValues();
		// cValues.put("twisterId", twister.gettwisterId());
		cValues.put("twisterDes", twister.getTwisterDes());
		cValues.put("twisterKey", twister.getTwisterKey());
		cValues.put("twisterKind", twister.getTwisterKind());
		cValues.put("twisterRemark", twister.getTwisterRemark());
		sdDatabase.insert(TABLE_NAME, null, cValues);
	}

	/**
	 * �ڶ��ַ�ʽ��������(����1W�����ݺ�ʱ��1365ms)
	 * 
	 * @param openHelper
	 * @param list
	 * @return
	 */
	public boolean insertMore(List<Twister> list) {

		if (null == list || list.size() <= 0) {
			return false;
		}
		try {
			sdDatabase.beginTransaction();
			for (Twister twister : list) {
				ContentValues cValues = new ContentValues();
				cValues.put("twisterDes", twister.getTwisterDes());
				cValues.put("twisterKey", twister.getTwisterKey());
				cValues.put("twisterKind", twister.getTwisterKind());
				cValues.put("twisterRemark", twister.getTwisterRemark());

				int count = (int) sdDatabase.insert(TABLE_NAME, null, cValues);

				if (count > 0) {
					return true;
				} else {
					return false;
				}
			}
			sdDatabase.setTransactionSuccessful();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (null != sdDatabase) {
					sdDatabase.endTransaction();
					sdDatabase.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	// ɾ��
	public boolean deltTwisterById(int id) {
		int nt = sdDatabase.delete(TABLE_NAME, "twisterId=?",
				new String[] { String.valueOf(id) });
		return nt > 0 ? true : false;
	}

	public boolean idValidTwisterKey(String rdes, String rkey) {
		Log.i("text", "ki" + rdes);
		Log.i("text", "ki" + rkey);
		Cursor cuserCursor = sdDatabase.query(TABLE_NAME, null, "twisterDes=?",
				new String[] { rdes }, null, null, null);

		Log.i("text", "cuserCursor" + cuserCursor);
		if (cuserCursor.getCount() > 0) {
			cuserCursor.moveToNext();
			Log.i("text", "ki rkey" + String.valueOf(cuserCursor.getString(2)));
			if (rkey.trim().equals(cuserCursor.getString(2).trim()))
				return true;
			else {
				return false;
			}
		} else {
			return false;
		}
	}
}
