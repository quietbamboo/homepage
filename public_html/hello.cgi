#!/usr/bin/perl
use Time::HiRes qw(gettimeofday);

  #$microseconds = 750_000;
  #usleep($microseconds);

  # signal alarm in 2.5s & every .1s thereafter
   #ualarm(2_500_000, 100_000);
      # cancel that ualarm
   #     ualarm(0);
  
         # get seconds and microseconds since the epoch
            ($s, $usec) = gettimeofday();
print "Content-type: text/html\r\n\r\n";
            ($s, $usec) = gettimeofday();
print $s, " ", $usec, "\n";
#print $elapsed;
