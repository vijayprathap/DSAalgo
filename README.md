DSAalgo

The goal of this project is to implement Digigtal Signature Algorithm(DSA). I did this project for a lab work in 
cryptography course. I did this project with one more friend of mine. Firstly we need to write a java program which can
read from different files and store the values required for signing, verification and key generation. These files are 
provided by our lab instructor. These are stored in files 'invalid','sign','verify' and 'keygen'. 

Firstly the 'signature.java' file reads the given file, stores the values in respective variables and then checks if 
the values are valid by the boolean isvalid() function. Then using respective flags, the operation to be done is found.
for eg if signing operation has to be done then the word 'sign' with be there in the file. Different classes are written
for different operations. 

The class 'Genkey.java' is used to generate a random key using the SecureRandom function as we are using these random
numbers for cryptographic operations. This random key x will be the private key and y is the public key which is
calculated using the formula (g^x)mod p. For these calculations, BigInteger functions are used as we are dealing with
numbers bigger than normal integers.

Similarly according to the signing and verification algorithm, 'SignKey.java' and 'VerifyKey.java' classes are
implemented. For refering to the working of DSA, refer to

'https://en.wikipedia.org/wiki/Digital_Signature_Algorithm'

Since we are performing calculations on huge numbers, the program must be as efficient as possible. We got long waiting 
times for key generation, which we have improved considerably. We got stuck in getting input from the file as it required
to be in loop, we need to have many conditions and checks here. in one particular condition, we used 

'if(line.contains("g"))' it showed crazy behaviour. Then we found instead of taking the g value, it takes g from the word
'genkey'. so inorder to differentiate both, we changed the code as 'if(line.contains("g="))'

=======
