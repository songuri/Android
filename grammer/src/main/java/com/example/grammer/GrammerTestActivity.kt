package com.example.grammer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class GrammerTestActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_grammer_test)
	}

	/**
	 * 함수 정의
	 */
	fun sum(a:Int, b:Int): Int{
		return a+b
	}

	fun sum2(a: Int, b: Int)= a+b

	/**
	 *  함수 정의2
	 *  - 리턴 할 값이 없는 경우 Unit(Object) 으로 리턴함
	 *  - Unit는 Java에서 void 리턴 역할
	 *  - Unit은 생략가능
	 */
	fun logKoltlin() : Unit {
		Log.d("kotlin", "Hello world")
	}
	fun logKoltlin2() {
		Log.d("kotlin", "Hello world")
	}


	fun basicSyntax() {
		/**
		 * 변수
		 * val : 읽기 전용 변수
		 */
		val a: Int = 1 //즉시할당
		val b = 2 // Int 추론한다.
		//val c:Int  // Compile Error

		var d = 1
		val S1 = "d is $d" // 이렇게 바로 접근 가능
		d = 2
		val S2 = "${S1.replace("is", "was")}, but now is $d"
	}

	fun maxOf(a: Int, b: Int) : Int {
		if(a > b) {
			return a
		} else {
			return b
		}
	}
	fun maxOf2(a: Int, b:Int) = if (a > b) a else b

	/**
	 * Nullable
	 * - 값이 Null 일 수 있는 경우 타입에 nullable 마크를 명시해야함.
	 * - 그렇지 않으면 컴파일 오류가 발생함
	 */
	fun parseInt(str: String): Int? {
		// 정수가 아닌 경우 null을 리턴
		return null
	}

	fun printProduct(arg1: String , arg2: String) {
		val x: Int? = parseInt(arg1)
		val y: Int? = parseInt(arg2)

		Log.d("Grammer", x.toString())
		val z: Int = x!!
	}

	fun getStringLength(obj: Any): Int? {
		if(obj is String) {
			return obj.length
		}
		return null
	}


	/**
	 * 코틀린에서 모든 것은 객체임
	 */

	fun test() {
		var a: Int = 10000
		var b: Int = 10000
		/**
		 * === 3개는 같은 identity
		 */
		println("${a === b}")
		val c = Array(5, {i -> i.toString()})

		var st: String = "KoKOKO"
		st = "abcde"
	}

}
