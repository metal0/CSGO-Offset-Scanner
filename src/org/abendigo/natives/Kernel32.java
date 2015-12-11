package org.abendigo.natives;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Tlhelp32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.win32.W32APIOptions;

import java.nio.ByteBuffer;

public final class Kernel32 {

	static {
		Native.register(NativeLibrary.getInstance("Kernel32", W32APIOptions.UNICODE_OPTIONS));
	}

	public static native WinNT.HANDLE CreateToolhelp32Snapshot(WinDef.DWORD var1, int var2);

	public static native boolean CloseHandle(WinNT.HANDLE var1);

	public static native WinNT.HANDLE OpenProcess(int desired, boolean inherit, int pid);

	public static native boolean Process32Next(WinNT.HANDLE var1, Tlhelp32.PROCESSENTRY32 var2);

	public static native boolean ReadProcessMemory(Pointer process, Pointer address, ByteBuffer memory, int size, int written);

}
