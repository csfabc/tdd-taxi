package com.jiker.keju;

import android.content.Context;
import org.junit.Test;
import androidx.test.platform.app.InstrumentationRegistry;
import static org.junit.Assert.assertEquals;

public class FileUtilTest {
	@Test
	public void test_open_file_error(){
		Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
		FileUtil fileUtil = new FileUtil("test.txt", appContext);
		assertEquals("", fileUtil.getData());
	}

	@Test
	public void test_data_count(){
		Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
		FileUtil fileUtil = new FileUtil("testData.txt", appContext);
		String expected = "1公里,等待0分钟\n3公里,等待0分钟\n10公里,等待0分钟\n2公里,等待3分钟\n";
		assertEquals(expected, fileUtil.getData());
	}
}
