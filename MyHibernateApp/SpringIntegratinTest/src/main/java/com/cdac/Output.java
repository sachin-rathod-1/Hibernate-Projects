package com.cdac;

import java.io.File;

public class Output
{
public static void main(String[] args) {

	int x=0;
	int y=10;
	do {
	y--;
	System.out.println(y);
	++x;
	System.out.println(x);
} while (x<5);
	System.out.println(x+""+y);
}
}

