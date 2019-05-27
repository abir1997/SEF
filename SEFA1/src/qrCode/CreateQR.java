package qrCode;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
public class CreateQR {

	public CreateQR(String url) {
		 try {
	            String qrCodeData = url;
	            String filePath = "code.png";
	            String charset = "UTF-8"; // or "ISO-8859-1"
	            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
	            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	            BitMatrix matrix = new MultiFormatWriter().encode(
	                new String(qrCodeData.getBytes(charset), charset),
	                BarcodeFormat.QR_CODE, 200, 200, hintMap);
	            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
	                .lastIndexOf('.') + 1), new File(filePath));
	          //  System.out.println("QR Code image created successfully!");
	        } catch (Exception e) {
	            System.err.println(e);
	        }
	    }
	
	
	

}
