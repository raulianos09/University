# CMAKE generated file: DO NOT EDIT!
# Generated by "NMake Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

!IF "$(OS)" == "Windows_NT"
NULL=
!ELSE
NULL=nul
!ENDIF
SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "D:\Programe\CLion\CLion 2020.3.2\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "D:\Programe\CLion\CLion 2020.3.2\bin\cmake\win\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles\SortedBag.dir\depend.make

# Include the progress variables for this target.
include CMakeFiles\SortedBag.dir\progress.make

# Include the compile flags for this target's objects.
include CMakeFiles\SortedBag.dir\flags.make

CMakeFiles\SortedBag.dir\Source_Files\ExtendedTest.cpp.obj: CMakeFiles\SortedBag.dir\flags.make
CMakeFiles\SortedBag.dir\Source_Files\ExtendedTest.cpp.obj: "..\Source Files\ExtendedTest.cpp"
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/SortedBag.dir/Source_Files/ExtendedTest.cpp.obj"
	C:\PROGRA~2\MICROS~1\2019\PROFES~1\VC\Tools\MSVC\1426~1.288\bin\Hostx86\x86\cl.exe @<<
 /nologo /TP $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) /FoCMakeFiles\SortedBag.dir\Source_Files\ExtendedTest.cpp.obj /FdCMakeFiles\SortedBag.dir\ /FS -c "C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\Source Files\ExtendedTest.cpp"
<<

CMakeFiles\SortedBag.dir\Source_Files\ExtendedTest.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/SortedBag.dir/Source_Files/ExtendedTest.cpp.i"
	C:\PROGRA~2\MICROS~1\2019\PROFES~1\VC\Tools\MSVC\1426~1.288\bin\Hostx86\x86\cl.exe > CMakeFiles\SortedBag.dir\Source_Files\ExtendedTest.cpp.i @<<
 /nologo /TP $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\Source Files\ExtendedTest.cpp"
<<

CMakeFiles\SortedBag.dir\Source_Files\ExtendedTest.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/SortedBag.dir/Source_Files/ExtendedTest.cpp.s"
	C:\PROGRA~2\MICROS~1\2019\PROFES~1\VC\Tools\MSVC\1426~1.288\bin\Hostx86\x86\cl.exe @<<
 /nologo /TP $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) /FoNUL /FAs /FaCMakeFiles\SortedBag.dir\Source_Files\ExtendedTest.cpp.s /c "C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\Source Files\ExtendedTest.cpp"
<<

CMakeFiles\SortedBag.dir\Source_Files\ShortTest.cpp.obj: CMakeFiles\SortedBag.dir\flags.make
CMakeFiles\SortedBag.dir\Source_Files\ShortTest.cpp.obj: "..\Source Files\ShortTest.cpp"
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/SortedBag.dir/Source_Files/ShortTest.cpp.obj"
	C:\PROGRA~2\MICROS~1\2019\PROFES~1\VC\Tools\MSVC\1426~1.288\bin\Hostx86\x86\cl.exe @<<
 /nologo /TP $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) /FoCMakeFiles\SortedBag.dir\Source_Files\ShortTest.cpp.obj /FdCMakeFiles\SortedBag.dir\ /FS -c "C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\Source Files\ShortTest.cpp"
<<

CMakeFiles\SortedBag.dir\Source_Files\ShortTest.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/SortedBag.dir/Source_Files/ShortTest.cpp.i"
	C:\PROGRA~2\MICROS~1\2019\PROFES~1\VC\Tools\MSVC\1426~1.288\bin\Hostx86\x86\cl.exe > CMakeFiles\SortedBag.dir\Source_Files\ShortTest.cpp.i @<<
 /nologo /TP $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\Source Files\ShortTest.cpp"
<<

CMakeFiles\SortedBag.dir\Source_Files\ShortTest.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/SortedBag.dir/Source_Files/ShortTest.cpp.s"
	C:\PROGRA~2\MICROS~1\2019\PROFES~1\VC\Tools\MSVC\1426~1.288\bin\Hostx86\x86\cl.exe @<<
 /nologo /TP $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) /FoNUL /FAs /FaCMakeFiles\SortedBag.dir\Source_Files\ShortTest.cpp.s /c "C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\Source Files\ShortTest.cpp"
<<

CMakeFiles\SortedBag.dir\Source_Files\SortedBag.cpp.obj: CMakeFiles\SortedBag.dir\flags.make
CMakeFiles\SortedBag.dir\Source_Files\SortedBag.cpp.obj: "..\Source Files\SortedBag.cpp"
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building CXX object CMakeFiles/SortedBag.dir/Source_Files/SortedBag.cpp.obj"
	C:\PROGRA~2\MICROS~1\2019\PROFES~1\VC\Tools\MSVC\1426~1.288\bin\Hostx86\x86\cl.exe @<<
 /nologo /TP $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) /FoCMakeFiles\SortedBag.dir\Source_Files\SortedBag.cpp.obj /FdCMakeFiles\SortedBag.dir\ /FS -c "C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\Source Files\SortedBag.cpp"
<<

CMakeFiles\SortedBag.dir\Source_Files\SortedBag.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/SortedBag.dir/Source_Files/SortedBag.cpp.i"
	C:\PROGRA~2\MICROS~1\2019\PROFES~1\VC\Tools\MSVC\1426~1.288\bin\Hostx86\x86\cl.exe > CMakeFiles\SortedBag.dir\Source_Files\SortedBag.cpp.i @<<
 /nologo /TP $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\Source Files\SortedBag.cpp"
<<

CMakeFiles\SortedBag.dir\Source_Files\SortedBag.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/SortedBag.dir/Source_Files/SortedBag.cpp.s"
	C:\PROGRA~2\MICROS~1\2019\PROFES~1\VC\Tools\MSVC\1426~1.288\bin\Hostx86\x86\cl.exe @<<
 /nologo /TP $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) /FoNUL /FAs /FaCMakeFiles\SortedBag.dir\Source_Files\SortedBag.cpp.s /c "C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\Source Files\SortedBag.cpp"
<<

CMakeFiles\SortedBag.dir\Source_Files\SortedBagIterator.cpp.obj: CMakeFiles\SortedBag.dir\flags.make
CMakeFiles\SortedBag.dir\Source_Files\SortedBagIterator.cpp.obj: "..\Source Files\SortedBagIterator.cpp"
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Building CXX object CMakeFiles/SortedBag.dir/Source_Files/SortedBagIterator.cpp.obj"
	C:\PROGRA~2\MICROS~1\2019\PROFES~1\VC\Tools\MSVC\1426~1.288\bin\Hostx86\x86\cl.exe @<<
 /nologo /TP $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) /FoCMakeFiles\SortedBag.dir\Source_Files\SortedBagIterator.cpp.obj /FdCMakeFiles\SortedBag.dir\ /FS -c "C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\Source Files\SortedBagIterator.cpp"
<<

CMakeFiles\SortedBag.dir\Source_Files\SortedBagIterator.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/SortedBag.dir/Source_Files/SortedBagIterator.cpp.i"
	C:\PROGRA~2\MICROS~1\2019\PROFES~1\VC\Tools\MSVC\1426~1.288\bin\Hostx86\x86\cl.exe > CMakeFiles\SortedBag.dir\Source_Files\SortedBagIterator.cpp.i @<<
 /nologo /TP $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\Source Files\SortedBagIterator.cpp"
<<

CMakeFiles\SortedBag.dir\Source_Files\SortedBagIterator.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/SortedBag.dir/Source_Files/SortedBagIterator.cpp.s"
	C:\PROGRA~2\MICROS~1\2019\PROFES~1\VC\Tools\MSVC\1426~1.288\bin\Hostx86\x86\cl.exe @<<
 /nologo /TP $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) /FoNUL /FAs /FaCMakeFiles\SortedBag.dir\Source_Files\SortedBagIterator.cpp.s /c "C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\Source Files\SortedBagIterator.cpp"
<<

CMakeFiles\SortedBag.dir\App.cpp.obj: CMakeFiles\SortedBag.dir\flags.make
CMakeFiles\SortedBag.dir\App.cpp.obj: ..\App.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "Building CXX object CMakeFiles/SortedBag.dir/App.cpp.obj"
	C:\PROGRA~2\MICROS~1\2019\PROFES~1\VC\Tools\MSVC\1426~1.288\bin\Hostx86\x86\cl.exe @<<
 /nologo /TP $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) /FoCMakeFiles\SortedBag.dir\App.cpp.obj /FdCMakeFiles\SortedBag.dir\ /FS -c C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\App.cpp
<<

CMakeFiles\SortedBag.dir\App.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/SortedBag.dir/App.cpp.i"
	C:\PROGRA~2\MICROS~1\2019\PROFES~1\VC\Tools\MSVC\1426~1.288\bin\Hostx86\x86\cl.exe > CMakeFiles\SortedBag.dir\App.cpp.i @<<
 /nologo /TP $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\App.cpp
<<

CMakeFiles\SortedBag.dir\App.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/SortedBag.dir/App.cpp.s"
	C:\PROGRA~2\MICROS~1\2019\PROFES~1\VC\Tools\MSVC\1426~1.288\bin\Hostx86\x86\cl.exe @<<
 /nologo /TP $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) /FoNUL /FAs /FaCMakeFiles\SortedBag.dir\App.cpp.s /c C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\App.cpp
<<

# Object files for target SortedBag
SortedBag_OBJECTS = \
"CMakeFiles\SortedBag.dir\Source_Files\ExtendedTest.cpp.obj" \
"CMakeFiles\SortedBag.dir\Source_Files\ShortTest.cpp.obj" \
"CMakeFiles\SortedBag.dir\Source_Files\SortedBag.cpp.obj" \
"CMakeFiles\SortedBag.dir\Source_Files\SortedBagIterator.cpp.obj" \
"CMakeFiles\SortedBag.dir\App.cpp.obj"

# External object files for target SortedBag
SortedBag_EXTERNAL_OBJECTS =

SortedBag.exe: CMakeFiles\SortedBag.dir\Source_Files\ExtendedTest.cpp.obj
SortedBag.exe: CMakeFiles\SortedBag.dir\Source_Files\ShortTest.cpp.obj
SortedBag.exe: CMakeFiles\SortedBag.dir\Source_Files\SortedBag.cpp.obj
SortedBag.exe: CMakeFiles\SortedBag.dir\Source_Files\SortedBagIterator.cpp.obj
SortedBag.exe: CMakeFiles\SortedBag.dir\App.cpp.obj
SortedBag.exe: CMakeFiles\SortedBag.dir\build.make
SortedBag.exe: CMakeFiles\SortedBag.dir\objects1.rsp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "Linking CXX executable SortedBag.exe"
	"D:\Programe\CLion\CLion 2020.3.2\bin\cmake\win\bin\cmake.exe" -E vs_link_exe --intdir=CMakeFiles\SortedBag.dir --rc=C:\PROGRA~2\WI3CF2~1\10\bin\100183~1.0\x86\rc.exe --mt=C:\PROGRA~2\WI3CF2~1\10\bin\100183~1.0\x86\mt.exe --manifests  -- C:\PROGRA~2\MICROS~1\2019\PROFES~1\VC\Tools\MSVC\1426~1.288\bin\Hostx86\x86\link.exe /nologo @CMakeFiles\SortedBag.dir\objects1.rsp @<<
 /out:SortedBag.exe /implib:SortedBag.lib /pdb:C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\cmake-build-debug\SortedBag.pdb /version:0.0  /machine:X86 /debug /INCREMENTAL /subsystem:console  kernel32.lib user32.lib gdi32.lib winspool.lib shell32.lib ole32.lib oleaut32.lib uuid.lib comdlg32.lib advapi32.lib 
<<

# Rule to build all files generated by this target.
CMakeFiles\SortedBag.dir\build: SortedBag.exe

.PHONY : CMakeFiles\SortedBag.dir\build

CMakeFiles\SortedBag.dir\clean:
	$(CMAKE_COMMAND) -P CMakeFiles\SortedBag.dir\cmake_clean.cmake
.PHONY : CMakeFiles\SortedBag.dir\clean

CMakeFiles\SortedBag.dir\depend:
	$(CMAKE_COMMAND) -E cmake_depends "NMake Makefiles" C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\cmake-build-debug C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\cmake-build-debug C:\Users\raul_\Desktop\DSA-LABS\Lab5\SortedBag\cmake-build-debug\CMakeFiles\SortedBag.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles\SortedBag.dir\depend
