package com.razer.java.chromagamesample;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.razer.java.JAppInfoType;
import com.razer.java.JChromaSDK;

public class ChromaGameSample extends ChromaEffects {
	
	private static final int MAX_ITEMS = 15;
	
	private static boolean sWaitForExit = true;
	private static boolean sChromaInitialized = false;
	private static int sSelectedItem = 1;
	
	private static void logMessage(String msg) {
		System.out.println(msg);
	}
	
	private static void logError(String msg) {
		System.err.println(msg);
	}

	public static void main(String[] args) {
		logMessage("JAVA Chroma Game Sample");
		
		sChromaAnimationAPI = JChromaSDK.getInstance();
		ChromaEffects.sChromaAnimationAPI = sChromaAnimationAPI;

		JAppInfoType appInfo = new JAppInfoType();

	    appInfo.setTitle("Java Chroma Game Sample");
	    appInfo.setDescription("A sample application using Razer Chroma SDK");
	    appInfo.setAuthorName("Razer");
	    appInfo.setAuthorContact("https://github.com/RazerOfficial/Java_ChromaGameSample");

	    //appInfo.SupportedDevice = 
	    //    0x01 | // Keyboards
	    //    0x02 | // Mice
	    //    0x04 | // Headset
	    //    0x08 | // Mousepads
	    //    0x10 | // Keypads
	    //    0x20   // ChromaLink devices
	    appInfo.supportedDevice = (0x01 | 0x02 | 0x04 | 0x08 | 0x10 | 0x20);
        //    0x01 | // Utility. (To specifiy this is an utility application)
        //    0x02   // Game. (To specifiy this is a game);
	    appInfo.category = 2;
		int result = sChromaAnimationAPI.initSDK(appInfo);
		if (result == 0) {
			sChromaInitialized = true;
			logMessage("Initialized ChromaSDK!");
			
			// Manually set event names
			sChromaAnimationAPI.useForwardChromaEvents(false);
		} else {
			logError("Failed to initialize ChromaSDK! error="+result);
			sChromaInitialized = false;
			logMessage("Application quit!");
			return;
		}
		
		executeItem(1);
		
		handleInput();
		
		uninit();
		
		logMessage("Application quit!");
	}
	
	private static void uninit() {
		sWaitForExit = false;
		Timer timer = new Timer("Timer");
		TimerTask task = new TimerTask() {
			public void run() {
				try {
					if (sChromaInitialized) {
						sChromaAnimationAPI.stopAll();
						sChromaAnimationAPI.closeAll();
						sChromaAnimationAPI.uninit();
						sChromaInitialized = false;
					}
					
					ChromaEffects.sChromaAnimationAPI = null;
					sChromaAnimationAPI = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		timer.schedule(task, 100);
	}
	
	private static void printLegend() {
		
		
		for (int index = 1; index <= MAX_ITEMS; ++index)
        {
            if (index == sSelectedItem)
            {
                System.out.print("[*] ");
            }
            else
            {
            	System.out.print("[ ] ");
            }
            System.out.print("Effect" + index);

            if ((index % 4) == 0)
            {
            	System.out.println();
            }
            else
            {
            	System.out.print("\t\t");
            }
        }
		System.out.println();
		
		logMessage("Enter the effect number and press `ENTER` to play the effect.");
		logMessage("Press `p` and press `ENTER` for the previous effect.");
		logMessage("Press `n` and press `ENTER` for the next effect.");
		logMessage("Press `s` and press `ENTER` to stop all haptic effects.");
		logMessage("Press `q` and press `ENTER` to quit\r\n");
	}
	
	private static void handleInput() {
		Scanner scanner = new Scanner(System.in);
		
		printLegend();
		while (sWaitForExit) {
			try {
				String input =  scanner.next();
				printLegend();
				int item = 0;
				switch (input) {
				case "p":
				case "P":
					if (sSelectedItem > 0) {
						--sSelectedItem;
					}
					item = sSelectedItem;
					break;
				case "n":
				case "N":
					if (sSelectedItem < MAX_ITEMS) {
						++sSelectedItem;
					}
					item = sSelectedItem;
					break;
				case "Q":
				case "q":
					scanner.close();
					return;
				case "S":
				case "s":
					// Stop haptic playback
					sChromaAnimationAPI.coreSetEventName("");
					break;
				default:
					item = Integer.parseInt(input);
					sSelectedItem = item;
					break;
				}
				executeItem(item);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void executeItem(int item) {
		switch (item)
        {
            case 1:
                showEffect1();
                showEffect1ChromaLink();
                showEffect1Headset();
                showEffect1Keypad();
                showEffect1Mousepad();
                showEffect1Mouse();
                break;
            case 2:
                showEffect2();
                showEffect2ChromaLink();
                showEffect2Headset();
                showEffect2Keypad();
                showEffect2Mousepad();
                showEffect2Mouse();
                break;
            case 3:
                showEffect3();
                showEffect3ChromaLink();
                showEffect3Headset();
                showEffect3Keypad();
                showEffect3Mousepad();
                showEffect3Mouse();
                break;
            case 4:
                showEffect4();
                showEffect4ChromaLink();
                showEffect4Headset();
                showEffect4Keypad();
                showEffect4Mousepad();
                showEffect4Mouse();
                break;
            case 5:
                showEffect5();
                showEffect5ChromaLink();
                showEffect5Headset();
                showEffect5Keypad();
                showEffect5Mousepad();
                showEffect5Mouse();
                break;
            case 6:
                showEffect6();
                showEffect6ChromaLink();
                showEffect6Headset();
                showEffect6Keypad();
                showEffect6Mousepad();
                showEffect6Mouse();
                break;
            case 7:
                showEffect7();
                showEffect7ChromaLink();
                showEffect7Headset();
                showEffect7Keypad();
                showEffect7Mousepad();
                showEffect7Mouse();
                break;
            case 8:
                showEffect8();
                showEffect8ChromaLink();
                showEffect8Headset();
                showEffect8Keypad();
                showEffect8Mousepad();
                showEffect8Mouse();
                break;
            case 9:
                showEffect9();
                showEffect9ChromaLink();
                showEffect9Headset();
                showEffect9Keypad();
                showEffect9Mousepad();
                showEffect9Mouse();
                break;
            case 10:
                showEffect10();
                showEffect10ChromaLink();
                showEffect10Headset();
                showEffect10Keypad();
                showEffect10Mousepad();
                showEffect10Mouse();
                break;
            case 11:
                showEffect11();
                showEffect11ChromaLink();
                showEffect11Headset();
                showEffect11Keypad();
                showEffect11Mousepad();
                showEffect11Mouse();
                break;
            case 12:
                showEffect12();
                showEffect12ChromaLink();
                showEffect12Headset();
                showEffect12Keypad();
                showEffect12Mousepad();
                showEffect12Mouse();
                break;
            case 13:
                showEffect13();
                showEffect13ChromaLink();
                showEffect13Headset();
                showEffect13Keypad();
                showEffect13Mousepad();
                showEffect13Mouse();
                break;
            case 14:
                showEffect14();
                showEffect14ChromaLink();
                showEffect14Headset();
                showEffect14Keypad();
                showEffect14Mousepad();
                showEffect14Mouse();
                break;
            case 15:
                showEffect15();
                showEffect15ChromaLink();
                showEffect15Headset();
                showEffect15Keypad();
                showEffect15Mousepad();
                showEffect15Mouse();
                break;
        }
	}

}
