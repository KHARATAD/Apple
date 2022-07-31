package com.infinity.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.infinity.keywords.UIKeywords;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class TestListenerApple implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result) {
		AShot ashot = new AShot();
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(2000));
		Screenshot sc = ashot.takeScreenshot(UIKeywords.getInstance().getDriver());
		BufferedImage img = sc.getImage();
		String dir = System.getProperty("user.dir");
		Date date= new Date();
		SimpleDateFormat dateformat=new SimpleDateFormat("ddMMyyyy_hhmmss");
		String pattern=dateformat.format(date);
		System.out.println(pattern);
		
			
			try {
				ImageIO.write(img, "PNG", new File(dir+"/src/failed_tests_screenshots/"+result.getName()+"_"+pattern+".png"));
			} catch (IOException e) {
				System.out.println("Unable to take Screenshot");
				e.printStackTrace();
			}
	}

}
