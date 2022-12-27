#include <iostream>
using namespace std;
int main(){
	string msg, crc,en="";
	cout<<"Enter the message=";
	getline(cin,msg);
	cout<<"Enter the crc generator polynomial=";
	getline(cin,crc);
	int m = msg.length(), n=crc.length();
	en+=msg;
	for(int i=1; i<=n-1; i++){
		en+='0';
	}
	for(int i=0; i<=en.length()-n;){
		for(int j=0; j<n; j++)
			en[i+j]=en[i+j] == crc[j] ? '0': '1';
		for(; i<en.length() && en[i]!='1'; i++);
	}
	cout<<"CRC is "+msg+en.substr(en.length()-n+1);
	string s = msg+en.substr(en.length()-n+1);
	cout<<s+"\n";
	//receiver side
	cout<<"\nAt receiver side\n";
	for(int i=0; i<=en.length()-crc.length();){
		for(int j=0; j<crc.length(); j++)
			s[i+j]=s[i+j] == crc[j] ? '0': '1';
		for(; i<s.length() && s[i]!='1'; i++);
	}
	for(char i: s.substr(s.length()-crc.length()))
		if(i!='0'){
			cout<<s.substr(s.length()-n+1);
			cout<<"\nError in communication...";
			return 0;
		}
	cout<<s.substr(s.length()-n+1);
	cout<<s.length();
	cout<<"\nData Transfered correctly!";
	return 0;
}