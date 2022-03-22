package com.aeye.nextlabel.temp.api

import com.aeye.nextlabel.temp.dto.UserJoin
import com.aeye.nextlabel.temp.dto.UserLeave
import com.aeye.nextlabel.temp.dto.UserLogin
import retrofit2.Response
import retrofit2.http.*

interface UserApi {
    // 모든 상대 주소는 임시로 작성한 것들
    // 차후 API 개발이 완료되면 수정할 예정

    // 1. 회원 가입
    @POST("/api/user/signup")
    suspend fun join(@Body user: UserJoin): Response<JoinResponse>

    // 2. 로그인
    @POST("/api/user/login")
    suspend fun login(@Body user: UserLogin): Response<LoginResponse>

    // 3. 회원 정보 수정
    @PUT("/api/user/update")
    suspend fun update(@Body user: UserJoin): Response<JoinResponse>

    // 4. 회원 탈퇴
    @DELETE("/api/user/signout")
    suspend fun leave(@Body user: UserLeave): Response<LoginResponse>
}