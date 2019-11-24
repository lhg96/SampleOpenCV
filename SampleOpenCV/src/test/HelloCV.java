package test;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

/**
 * 
 * reference
 * https://blog.naver.com/PostView.nhn?blogId=idrukawa&logNo=221238267875&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView
 * 
 * @author user
 *
 */
public class HelloCV {
	public static void main(String[] args) {
		// First of all we need to load the OpenCV Native Library previously set on our
		// project.
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		// Then we can define a new Mat.
		Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);

		System.out.println("mat = " + mat.dump());
	}
}
