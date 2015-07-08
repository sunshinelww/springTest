package com.baobaotao.place;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

public class DESEncryptUtil {

	public static Key createKey() throws NoSuchAlgorithmException {
		Security.insertProviderAt(new com.sun.crypto.provider.SunJCE(), 1);
		KeyGenerator generator = KeyGenerator.getInstance("DES");
		generator.init(new SecureRandom());

		Key key = generator.generateKey();
		return key;
	}

	public static Key getKey(InputStream is) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(is);
			return (Key) ois.readObject();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private static byte[] doEncrypt(Key key, byte[] data) {
		try {
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] raw = cipher.doFinal(data);
			return raw;
		} catch (NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static InputStream doDecrypt(Key key, InputStream in) {

		try {
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key);
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			byte[] tempBuf = new byte[1024];
			int count = 0;
			while ((count = in.read(tempBuf)) != -1) {
				bout.write(tempBuf, 0, count);
				tempBuf = new byte[1024];
			}
			in.close();
			byte[] orgData = bout.toByteArray();

			byte[] raw = cipher.doFinal(orgData);
			// 包装成输入流返回
			ByteArrayInputStream bin = new ByteArrayInputStream(raw);
			return bin;
		} catch (NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidKeyException | IOException | IllegalBlockSizeException
				| BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {

		/**
		 * 生成密钥文件
		 * 
		 * String keyFilePath="D:\\key.dat"; try { Key
		 * key=DESEncryptUtil.createKey(); ObjectOutputStream oos=new
		 * ObjectOutputStream( new FileOutputStream(keyFilePath));
		 * oos.writeObject(key); oos.close(); } catch (NoSuchAlgorithmException
		 * | IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		/*
		 * File file=new File("D:\\car.propertise"); try { FileInputStream
		 * fis=new FileInputStream(file); ByteArrayOutputStream bout=new
		 * ByteArrayOutputStream(); byte[] tempBuf=new byte[1024]; int count=0;
		 * while((count=fis.read())!=-1){ bout.write(tempBuf); tempBuf=new
		 * byte[1024]; } fis.close(); byte[] orgData=bout.toByteArray(); Key
		 * key=getKey(new FileInputStream("D:\\key.dat")); byte[]
		 * raw=DESEncryptUtil.doEncrypt(key, orgData); file=new
		 * File(file.getParent()+"en_"+file.getName()); FileOutputStream fos=new
		 * FileOutputStream(file); fos.write(raw); fos.close();
		 * System.out.println("成功加密，加密文件位于"+file.getAbsolutePath()); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		/*
		 * File file=new File("D:\\en_car.propertise"); try { FileInputStream
		 * fis=new FileInputStream(file); Key key=getKey(new
		 * FileInputStream("D:\\key.dat")); InputStream
		 * raw=DESEncryptUtil.doDecrypt(key, fis);
		 * 
		 * ByteArrayOutputStream bout=new ByteArrayOutputStream(); byte[]
		 * tempBuf=new byte[1024]; int count=0;
		 * while((count=raw.read(tempBuf))!=-1){ bout.write(tempBuf,0,count);
		 * tempBuf=new byte[1024]; } raw.close(); byte[]
		 * orgData=bout.toByteArray(); file = new File(file.getParent() +
		 * "\\rs_" + file.getName()); FileOutputStream fos = new
		 * FileOutputStream(file); fos.write(orgData); fos.close();
		 * System.out.println("成功解密，解密文件位于:"+file.getAbsolutePath()); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		args = new String[] {
				"decrypt",
				"D:\\en_car.propertise",
				"D:\\key.dat" };
		// args = new String[]{
		// "encrypt",
		// "D:\\masterSpring\\chapter5\\src\\com\\baobaotao\\place\\car.properties",
		// "D:\\masterSpring\\chapter5\\src\\com\\baobaotao\\place\\key.dat"};
		// args = new String[]{
		// "key",
		// "D:\\masterSpring\\chapter5\\src\\com\\baobaotao\\place\\key.dat"};
		try {
			if (args.length == 2 && args[0].equals("key")) {// 生成密钥文件
				Key key = DESEncryptUtil.createKey();
				ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream(args[1]));
				oos.writeObject(key);
				oos.close();
				System.out.println("成功生成密钥文件。");
			} else if (args.length == 3 && args[0].equals("encrypt")) {// 对文件进行加密
				File file = new File(args[1]);
				FileInputStream in = new FileInputStream(file);
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				byte[] tmpbuf = new byte[1024];
				int count = 0;
				while ((count = in.read(tmpbuf)) != -1) {
					bout.write(tmpbuf, 0, count);
					tmpbuf = new byte[1024];
				}
				in.close();
				byte[] orgData = bout.toByteArray();
				Key key = getKey(new FileInputStream(args[2]));
				byte[] raw = DESEncryptUtil.doEncrypt(key, orgData);
				file = new File(file.getParent() + "\\en_" + file.getName());

				FileOutputStream out = new FileOutputStream(file);
				out.write(raw);
				out.close();
				System.out.println("成功加密，加密文件位于:" + file.getAbsolutePath());
			} else if (args.length == 3 && args[0].equals("decrypt")) {

				File file = new File(args[1]);
				FileInputStream fis = new FileInputStream(file);
				Key key = getKey(new FileInputStream(args[2]));
				InputStream raw = DESEncryptUtil.doDecrypt(key, fis);

				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				byte[] tmpbuf = new byte[1024];
				int count = 0;
				while ((count = raw.read(tmpbuf)) != -1) {
					bout.write(tmpbuf, 0, count);
					tmpbuf = new byte[1024];
				}
				raw.close();
				byte[] orgData = bout.toByteArray();
				file = new File(file.getParent() + "\\rs_" + file.getName());
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(orgData);
				System.out.println("成功解密，解密文件位于:" + file.getAbsolutePath());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
