/**
 * 
 */
package com.crm.util;

import java.util.Random;

/**
 * @author lenovo
 *
 */
public class MathUtil {
   
    /**
     * 把数据在数据库中的ID转化为多位显示用的String ID.
     * @param id
     * @return
     */
    public static String getFormatID(int id) {
	String result = "" + id;
	if (result.length() == 1) {
	    result = "10000" + result;
	}
	else if (result.length() == 2) {
	    result = "1000" + result;
	}
	else if (result.length() == 3) {
	    result = "100" + result;
	}
	else if (result.length() == 4) {
	    result = "10" + result;
	}
	else if (result.length() == 5) {
	    result = "1" + result;
	}
	else {
	    result = "1" + result;
	}
	return result;
    }
    
    /**
     * 返回一个指定范围内的随机数
     * @param size
     * @return
     */
    public static int getRandom(int size) {
	Random random =  new Random();
	return random.nextInt(size);
    }
    
    public static double getRandomPrice(double begin, double end) {
	double price = 0;
	Random random = new Random();
	double seed = random.nextDouble() * 10000;
	while (true) {
	    if (seed > begin && seed < end) {
		price = seed;
		break;
	    }
	    seed = random.nextDouble() * 10000;
	}
	return price;
    }
    
    public static double getRandomArea(double begin, double end) {
	double price = 0;
	Random random = new Random();
	double seed = random.nextDouble() * 1000;
	while (true) {
	    if (seed > begin && seed < end) {
		price = seed;
		break;
	    }
	    seed = random.nextDouble() * 1000;
	}
	return price;
    }
}
