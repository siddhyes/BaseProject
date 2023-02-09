package com.example.api

class APIException(var code:Int=0,var messageString: String) :Exception(messageString) {

}