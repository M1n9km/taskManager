package com.taskmanager.util;

import java.security.MessageDigest;

public class MD5 {
	public static class MD5Util {

		/**
		 * ���ַ�������ΪMD5���Ĵ�
		 * @param strToCode Ҫ���ܵ��ַ���
		 * @return ����MD5���ܵ�32λ���Ĵ�
		 */
		public static String ecodeByMD5(String strToCode) {
			MessageDigest messageDigest = null;
			try {
				messageDigest = MessageDigest.getInstance("MD5");
				byte[] bytesToCode = strToCode.getBytes("UTF-8");
				byte[] md5Bytes = messageDigest.digest(bytesToCode);
				StringBuffer md5StringBuffer = new StringBuffer();
				for (int i = 0; i < md5Bytes.length; i++) {
					int intValue = ((int) md5Bytes[i]) & 0xff;
					if (intValue < 16)
						md5StringBuffer.append("0");
					md5StringBuffer.append(Integer.toHexString(intValue));
				}
				return md5StringBuffer.toString();

			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}

	}
}
