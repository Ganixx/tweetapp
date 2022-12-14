package com.tweetapp.service;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tweetapp.exception.InvalidOtpException;
import com.tweetapp.exception.UserAlreadyExsistsException;
import com.tweetapp.model.AppUserRequestDto;
import com.tweetapp.model.AppUserResponseDto;
import com.tweetapp.model.FollowDto;
import com.tweetapp.model.ForgotPassword;
import com.tweetapp.model.OutputDto;
import com.tweetapp.model.SearchAppUserResponseDto;

public interface AppUserService {
    public OutputDto<Page<AppUserResponseDto>> getAllAppUsers(int page, int size);

    public AppUserResponseDto createUser(AppUserRequestDto userReq) throws InvalidOtpException, UserAlreadyExsistsException;

    public Boolean existsByLoginId(String loginId) throws UserAlreadyExsistsException;

    public Boolean existsByEmail(String email) throws UserAlreadyExsistsException;

    public Boolean updatePassword(ForgotPassword forgotPassword) throws InvalidOtpException, UsernameNotFoundException;

    public String followHelper(FollowDto followDto,String userId) throws UsernameNotFoundException;

    public OutputDto<Page<SearchAppUserResponseDto>> searchUser(String searchText,String principal, int page, int size);

    public OutputDto<AppUserResponseDto> findUserbyId(String userId,String principal);

}
