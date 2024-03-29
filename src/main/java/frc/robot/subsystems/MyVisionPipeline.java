//public class MyVisionPipeline implements edu.wpi.first.vision.VisionPipeline{

	package frc.robot.subsystems;
	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Map;
	import java.util.stream.Collectors;
	import java.util.HashMap;
	
	import edu.wpi.first.wpilibj.vision.VisionPipeline;
	
	import org.opencv.core.*;
	import org.opencv.core.Core.*;
	import org.opencv.features2d.FeatureDetector;
	import org.opencv.imgcodecs.Imgcodecs;
	import org.opencv.imgproc.*;
	import org.opencv.objdetect.*;
	
	/**
	* MyVisionPipeline class.
	*
	* <p>An OpenCV pipeline generated by GRIP.
	*
	* @author GRIP
	*/
	public class MyVisionPipeline implements edu.wpi.first.vision.VisionPipeline {
	
		//Outputs
		private Mat resizeImageOutput = new Mat();
		private Mat hslThresholdOutput = new Mat();
		private Mat cvErode0Output = new Mat();
		private Mat maskOutput = new Mat();
		private Mat hsvThresholdOutput = new Mat();
		private Mat cvErode1Output = new Mat();
		private Mat blurOutput = new Mat();
		private MatOfKeyPoint findBlobsOutput = new MatOfKeyPoint();
	
		static {
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		}
	
		/**
		 * This is the primary method that runs the entire pipeline and updates the outputs.
		 */
		@Override	public void process(Mat source0) {
			// Step Resize_Image0:
			Mat resizeImageInput = source0;
			double resizeImageWidth = 640.0;
			double resizeImageHeight = 480.0;
			int resizeImageInterpolation = Imgproc.INTER_CUBIC;
			resizeImage(resizeImageInput, resizeImageWidth, resizeImageHeight, resizeImageInterpolation, resizeImageOutput);
	
			// Step HSL_Threshold0:
			Mat hslThresholdInput = resizeImageOutput;
			double[] hslThresholdHue = {0.0, 180.0};
			double[] hslThresholdSaturation = {0.0, 255.0};
			double[] hslThresholdLuminance = {246.35593220338978, 255.0};
			hslThreshold(hslThresholdInput, hslThresholdHue, hslThresholdSaturation, hslThresholdLuminance, hslThresholdOutput);
	
			// Step CV_erode0:
			Mat cvErode0Src = hslThresholdOutput;
			Mat cvErode0Kernel = new Mat();
			Point cvErode0Anchor = new Point(-1, -1);
			double cvErode0Iterations = 4.0;
			int cvErode0Bordertype = Core.BORDER_CONSTANT;
			Scalar cvErode0Bordervalue = new Scalar(-1);
			cvErode(cvErode0Src, cvErode0Kernel, cvErode0Anchor, cvErode0Iterations, cvErode0Bordertype, cvErode0Bordervalue, cvErode0Output);
	
			// Step Mask0:
			Mat maskInput = resizeImageOutput;
			Mat maskMask = cvErode0Output;
			mask(maskInput, maskMask, maskOutput);
	
			// Step HSV_Threshold0:
			Mat hsvThresholdInput = maskOutput;
			double[] hsvThresholdHue = {40.92488720887697, 48.36007130124778};
			double[] hsvThresholdSaturation = {0.0, 221.91919191919192};
			double[] hsvThresholdValue = {235.7909604519774, 255.0};
			hsvThreshold(hsvThresholdInput, hsvThresholdHue, hsvThresholdSaturation, hsvThresholdValue, hsvThresholdOutput);
	
			// Step CV_erode1:
			Mat cvErode1Src = hsvThresholdOutput;
			Mat cvErode1Kernel = new Mat();
			Point cvErode1Anchor = new Point(-1, -1);
			double cvErode1Iterations = 3.0;
			int cvErode1Bordertype = Core.BORDER_CONSTANT;
			Scalar cvErode1Bordervalue = new Scalar(-1);
			cvErode(cvErode1Src, cvErode1Kernel, cvErode1Anchor, cvErode1Iterations, cvErode1Bordertype, cvErode1Bordervalue, cvErode1Output);
	
			// Step Blur0:
			Mat blurInput = cvErode1Output;
			BlurType blurType = BlurType.get("Box Blur");
			double blurRadius = 16.50943396226415;
			blur(blurInput, blurType, blurRadius, blurOutput);
	
			// Step Find_Blobs0:
			Mat findBlobsInput = blurOutput;
			double findBlobsMinArea = 2.0;
			double[] findBlobsCircularity = {0.0, 1.0};
			boolean findBlobsDarkBlobs = false;
			findBlobs(findBlobsInput, findBlobsMinArea, findBlobsCircularity, findBlobsDarkBlobs, findBlobsOutput);
	
		}
	
		/**
		 * This method is a generated getter for the output of a Resize_Image.
		 * @return Mat output from Resize_Image.
		 */
		public Mat resizeImageOutput() {
			return resizeImageOutput;
		}
	
		/**
		 * This method is a generated getter for the output of a HSL_Threshold.
		 * @return Mat output from HSL_Threshold.
		 */
		public Mat hslThresholdOutput() {
			return hslThresholdOutput;
		}
	
		/**
		 * This method is a generated getter for the output of a CV_erode.
		 * @return Mat output from CV_erode.
		 */
		public Mat cvErode0Output() {
			return cvErode0Output;
		}
	
		/**
		 * This method is a generated getter for the output of a Mask.
		 * @return Mat output from Mask.
		 */
		public Mat maskOutput() {
			return maskOutput;
		}
	
		/**
		 * This method is a generated getter for the output of a HSV_Threshold.
		 * @return Mat output from HSV_Threshold.
		 */
		public Mat hsvThresholdOutput() {
			return hsvThresholdOutput;
		}
	
		/**
		 * This method is a generated getter for the output of a CV_erode.
		 * @return Mat output from CV_erode.
		 */
		public Mat cvErode1Output() {
			return cvErode1Output;
		}
	
		/**
		 * This method is a generated getter for the output of a Blur.
		 * @return Mat output from Blur.
		 */
		public Mat blurOutput() {
			return blurOutput;
		}
	
		/**
		 * This method is a generated getter for the output of a Find_Blobs.
		 * @return MatOfKeyPoint output from Find_Blobs.
		 */
		public MatOfKeyPoint findBlobsOutput() {
			return findBlobsOutput;
		}
	
	
		/**
		 * Scales and image to an exact size.
		 * @param input The image on which to perform the Resize.
		 * @param width The width of the output in pixels.
		 * @param height The height of the output in pixels.
		 * @param interpolation The type of interpolation.
		 * @param output The image in which to store the output.
		 */
		private void resizeImage(Mat input, double width, double height,
			int interpolation, Mat output) {
			Imgproc.resize(input, output, new Size(width, height), 0.0, 0.0, interpolation);
		}
	
		/**
		 * Segment an image based on hue, saturation, and luminance ranges.
		 *
		 * @param input The image on which to perform the HSL threshold.
		 * @param hue The min and max hue
		 * @param sat The min and max saturation
		 * @param lum The min and max luminance
		 * @param output The image in which to store the output.
		 */
		private void hslThreshold(Mat input, double[] hue, double[] sat, double[] lum,
			Mat out) {
			Imgproc.cvtColor(input, out, Imgproc.COLOR_BGR2HLS);
			Core.inRange(out, new Scalar(hue[0], lum[0], sat[0]),
				new Scalar(hue[1], lum[1], sat[1]), out);
		}
	
		/**
		 * Filter out an area of an image using a binary mask.
		 * @param input The image on which the mask filters.
		 * @param mask The binary image that is used to filter.
		 * @param output The image in which to store the output.
		 */
		private void mask(Mat input, Mat mask, Mat output) {
			mask.convertTo(mask, CvType.CV_8UC1);
			Core.bitwise_xor(output, output, output);
			input.copyTo(output, mask);
		}
	
		/**
		 * Segment an image based on hue, saturation, and value ranges.
		 *
		 * @param input The image on which to perform the HSL threshold.
		 * @param hue The min and max hue
		 * @param sat The min and max saturation
		 * @param val The min and max value
		 * @param output The image in which to store the output.
		 */
		private void hsvThreshold(Mat input, double[] hue, double[] sat, double[] val,
			Mat out) {
			Imgproc.cvtColor(input, out, Imgproc.COLOR_BGR2HSV);
			Core.inRange(out, new Scalar(hue[0], sat[0], val[0]),
				new Scalar(hue[1], sat[1], val[1]), out);
		}
	
		/**
		 * Expands area of lower value in an image.
		 * @param src the Image to erode.
		 * @param kernel the kernel for erosion.
		 * @param anchor the center of the kernel.
		 * @param iterations the number of times to perform the erosion.
		 * @param borderType pixel extrapolation method.
		 * @param borderValue value to be used for a constant border.
		 * @param dst Output Image.
		 */
		private void cvErode(Mat src, Mat kernel, Point anchor, double iterations,
			int borderType, Scalar borderValue, Mat dst) {
			if (kernel == null) {
				kernel = new Mat();
			}
			if (anchor == null) {
				anchor = new Point(-1,-1);
			}
			if (borderValue == null) {
				borderValue = new Scalar(-1);
			}
			Imgproc.erode(src, dst, kernel, anchor, (int)iterations, borderType, borderValue);
		}
	
		/**
		 * An indication of which type of filter to use for a blur.
		 * Choices are BOX, GAUSSIAN, MEDIAN, and BILATERAL
		 */
		enum BlurType{
			BOX("Box Blur"), GAUSSIAN("Gaussian Blur"), MEDIAN("Median Filter"),
				BILATERAL("Bilateral Filter");
	
			private final String label;
	
			BlurType(String label) {
				this.label = label;
			}
	
			public static BlurType get(String type) {
				if (BILATERAL.label.equals(type)) {
					return BILATERAL;
				}
				else if (GAUSSIAN.label.equals(type)) {
				return GAUSSIAN;
				}
				else if (MEDIAN.label.equals(type)) {
					return MEDIAN;
				}
				else {
					return BOX;
				}
			}
	
			@Override
			public String toString() {
				return this.label;
			}
		}
	
		/**
		 * Softens an image using one of several filters.
		 * @param input The image on which to perform the blur.
		 * @param type The blurType to perform.
		 * @param doubleRadius The radius for the blur.
		 * @param output The image in which to store the output.
		 */
		private void blur(Mat input, BlurType type, double doubleRadius,
			Mat output) {
			int radius = (int)(doubleRadius + 0.5);
			int kernelSize;
			switch(type){
				case BOX:
					kernelSize = 2 * radius + 1;
					Imgproc.blur(input, output, new Size(kernelSize, kernelSize));
					break;
				case GAUSSIAN:
					kernelSize = 6 * radius + 1;
					Imgproc.GaussianBlur(input,output, new Size(kernelSize, kernelSize), radius);
					break;
				case MEDIAN:
					kernelSize = 2 * radius + 1;
					Imgproc.medianBlur(input, output, kernelSize);
					break;
				case BILATERAL:
					Imgproc.bilateralFilter(input, output, -1, radius, radius);
					break;
			}
		}
	
		/**
		 * Detects groups of pixels in an image.
		 * @param input The image on which to perform the find blobs.
		 * @param minArea The minimum size of a blob that will be found
		 * @param circularity The minimum and maximum circularity of blobs that will be found
		 * @param darkBlobs The boolean that determines if light or dark blobs are found.
		 * @param blobList The output where the MatOfKeyPoint is stored.
		 */
		private void findBlobs(Mat input, double minArea, double[] circularity,
			Boolean darkBlobs, MatOfKeyPoint blobList) {
			FeatureDetector blobDet = FeatureDetector.create(FeatureDetector.SIMPLEBLOB);
			try {
				File tempFile = File.createTempFile("config", ".xml");
	
				StringBuilder config = new StringBuilder();
	
				config.append("<?xml version=\"1.0\"?>\n");
				config.append("<opencv_storage>\n");
				config.append("<thresholdStep>10.</thresholdStep>\n");
				config.append("<minThreshold>50.</minThreshold>\n");
				config.append("<maxThreshold>220.</maxThreshold>\n");
				config.append("<minRepeatability>2</minRepeatability>\n");
				config.append("<minDistBetweenBlobs>10.</minDistBetweenBlobs>\n");
				config.append("<filterByColor>1</filterByColor>\n");
				config.append("<blobColor>");
				config.append((darkBlobs ? 0 : 255));
				config.append("</blobColor>\n");
				config.append("<filterByArea>1</filterByArea>\n");
				config.append("<minArea>");
				config.append(minArea);
				config.append("</minArea>\n");
				config.append("<maxArea>");
				config.append(Integer.MAX_VALUE);
				config.append("</maxArea>\n");
				config.append("<filterByCircularity>1</filterByCircularity>\n");
				config.append("<minCircularity>");
				config.append(circularity[0]);
				config.append("</minCircularity>\n");
				config.append("<maxCircularity>");
				config.append(circularity[1]);
				config.append("</maxCircularity>\n");
				config.append("<filterByInertia>1</filterByInertia>\n");
				config.append("<minInertiaRatio>0.1</minInertiaRatio>\n");
				config.append("<maxInertiaRatio>" + Integer.MAX_VALUE + "</maxInertiaRatio>\n");
				config.append("<filterByConvexity>1</filterByConvexity>\n");
				config.append("<minConvexity>0.95</minConvexity>\n");
				config.append("<maxConvexity>" + Integer.MAX_VALUE + "</maxConvexity>\n");
				config.append("</opencv_storage>\n");
				FileWriter writer;
				writer = new FileWriter(tempFile, false);
				writer.write(config.toString());
				writer.close();
				blobDet.read(tempFile.getPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			blobDet.detect(input, blobList);
		}
	
	
	
	
	}
	
	