#include <iostream>
using namespace std;
int main(){
	string msg, crc,en="";
	cout<<"Enter the message=";
	getline(cin,msg);
	cout<<"Enter the crc generator polynomial=";
	getline(cin,crc);
	for(int i=0; i<=en.length()-crc.length();){
		for(int j=0; j<crc.length(); j++)
			en[i+j]=en[i+j] == crc[j] ? '0': '1';
		for(; i<en.length() && en[i]!='1'; i++);
	}
	for(char i: en.substr(en.length()-crc.length()))
		if(i!='0'){
			cout<<"Error in communication...";
			return 0;
		}
	cout<<"No Error!";
	return 0;
}