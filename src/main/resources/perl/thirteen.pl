$walker = 0;
$found = 0;

print "The prime numbers between 2 and $n are:\n";

for($i=1;;$i++){
    $is_prime = ($i % 2 == 0 || $i % 3 == 0 || $i % 5 == 0 || $i == 1) ? 1 : 0;
    if($is_prime == 1) {
        $walker++;
        if($walker == 10000) {
            $found = $i;
            last;
        }
    }
}

print "Luke 13: Prime-number 10000 that is based on 2,3 or 5 is {$found}\n";