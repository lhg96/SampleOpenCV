package test;

import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class HoughCircles {
	public static void main(String[] args) {
		// Load the native library.
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		new HoughCirclesRun().run(args);
	}
}

class HoughCirclesRun{
	public void run(String[] args) {
        //String default_file = "../../../../data/smarties.png";
    	//String default_file = "sample1.jpg";
    	//String default_file ="Chohralsky_Silicon_Crystal_Growth.jpg";
    	String default_file = "201912041655.png";
		//String default_file = "smarties.png";
    	
        String filename = ((args.length > 0) ? args[0] : default_file);
        
        // Load an image
        Mat src = Imgcodecs.imread(filename, Imgcodecs.IMREAD_COLOR);
        
        // Check if image is loaded fine
        if( src.empty() ) {
            System.out.println("Error opening image!");
            System.out.println("Program Arguments: [image_name -- default "
                    + default_file +"] \n");
            System.exit(-1);
        }
        
        Mat gray = new Mat();
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
        //Imgproc.GaussianBlur( gray, gray, new Size(9, 9), 2, 2 );
        //Imgproc.medianBlur(gray, gray, 5);
        
        Mat circles = new Mat();        
        
        /*
        Imgproc.HoughCircles(gray, circles,	Imgproc.HOUGH_GRADIENT, 
        		1.0, (double)gray.rows()/16, // change this value to detect circles with different distances to each other
                100.0, 30.0, 
                1, 30); // change the last two parameters
                // (min_radius & max_radius) to detect larger circles
         */
        //Imgproc.HoughCircles(gray, circles, Imgproc.CV_HOUGH_GRADIENT, 1, 1, 160, 25, 0, 0);
        //https://webnautes.tistory.com/949
        Imgproc.HoughCircles(gray, circles, Imgproc.CV_HOUGH_GRADIENT, 
        		1, 1, 
        		80, 26,
        		0, 0);
        		//0,0);
        /*
        circles = cv.HoughCircles( image, method, 
        		dp, minDist[, 
        		circles[, param1[, param2[,
        		minRadius[, maxRadius]]]]] )
      	*/
        
        for (int x = 0; x < circles.cols(); x++) {
            double[] c = circles.get(0, x);
            Point center = new Point(Math.round(c[0]), Math.round(c[1]));
            // circle center
            Imgproc.circle(src, center, 1, new Scalar(0,100,100), 3, 8, 0 );
            // circle outline
            int radius = (int) Math.round(c[2]);
            
            System.out.println(radius);
            Imgproc.circle(src, center, radius, new Scalar(255,0,255), 3, 8, 0 );
        }
        HighGui.imshow("detected circles", src);
        
        //HighGui.imshow("gray", gray);
        HighGui.waitKey();
        System.exit(0);
    }
}
