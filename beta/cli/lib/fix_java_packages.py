# Copyright 2014 Runtime Verification Inc., All Rights Reserved

# Move all Java files in rvm_tmp/ directory from where this script is called
# to their correct locations based on the pacakges they are defined in.
# Throw error if class in default package (no package specified) encountered.

import sys, os, re

base_dir = os.getcwd()

os.chdir('rvm_tmp')

for file in os.listdir('.'):
    if file.endswith('.java'):
        file_contents = open(file).read()
        results = re.search('package\\s+([a-zA_Z_][\\.\\w]*);', file_contents)
        if results is None:
            # Compile to default package (no package definition found)
            status = os.system('javac -cp ' + base_dir + '/lib/rvmonitorrt.jar:' + base_dir + '/lib/android-17/android.jar:' + base_dir + '/tmp/no_monitor_$1.jar ' + file)
            if status != 0:
                print 'Error in Java compilation.  Dying!'
                exit(1)
            os.system('rm ' + file)
        else:
            # Determine package, compile in appropriate package directory
            package = results.group(0).split()
            assert(package[0] == 'package')
            assert(package[1][-1] == ';')
            package_path = package[1][:-1].split('.')
            current_path = './'            
            for directory in package_path:
                current_path += (directory + '/')
                os.system('mkdir ' + current_path)
            os.system('mv ' + file + ' ' + current_path + '.')
            current_dir = os.getcwd()
            os.chdir(current_path)
            status = os.system('javac -cp ' + base_dir + '/lib/rvmonitorrt.jar:' + base_dir + '/lib/android-17/android.jar:' + base_dir + '/tmp/no_monitor_$1.jar ' + file)
            if status != 0:
                print 'Error in Java compilation.  Dying!'
                exit(1)
            os.system('rm ' + file)
            os.chdir(current_dir)
