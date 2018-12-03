const isPrime = num => {
    for(let i = 2, s = Math.sqrt(num); i <= s; i++)
        if(num % i === 0) return false;
    return num !== 1 && num !== 0;
}

const getNextPrime = current => {
    let found = false;
    let nextPrime = current;
    while (!found) {
        nextPrime++;
        if (isPrime(nextPrime)) {
        found = nextPrime;
        }
    }
    return nextPrime;
}

const sumArray = array =>  {
    let result = 1;
    array.forEach((next) => {
      result = result * next;
    });
    return result;
  }

const recursiveJuletall = (start, rest, max) => {
    let nextPrime = rest.length ? getNextPrime(2) : 2;

    const index = start.length - 1;
    const tempArray = start.concat(rest);

    let juletall = [];
    let result = 0;

    while (result < max && (nextPrime <= rest[0] || rest.length === 0) && start.length > 0) {
        tempArray[index] = nextPrime;
        result = sumArray(tempArray);

        if (result < max) {
        juletall.push(tempArray);
        const subresult = recursiveJuletall(tempArray.slice(0, index), [].concat(nextPrime).concat(rest), max);

        juletall.push(...subresult);

        nextPrime = getNextPrime(nextPrime);
        } else {
        break;
        }
    }

    return juletall;
}
console.log('Antall juletall: ', recursiveJuletall(new Array(24).fill(2), [], 4294967296).length);