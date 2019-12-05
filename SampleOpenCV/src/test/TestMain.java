package test;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class TestMain {

	public static void main(String[] args) {
		System.out.println("test Main");
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		// Then we can define a new Mat.
		Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
		System.out.println("mat = " + mat.dump());
		/*
        //image container object
        Mat imageArray;
        //Read image from file system
        imageArray=Imgcodecs.imread("C:\\Users\\mesutpiskin\\sample.jpg");
        //Get image with & height
        System.out.println(imageArray.rows());
        System.out.println(imageArray.cols());
        */
	}

}
