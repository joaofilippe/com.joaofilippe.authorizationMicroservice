package com.joaofilippe.authorizationmicroservice.app.domain.usecases.user;

import com.joaofilippe.authorizationmicroservice.app.domain.repositories.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class GetByIdUseCaseTest {
    private IUserRepository userRepository;
    private GetByIdUseCase getByIdUseCase;

    @BeforeEach
    void setUp(){
        userRepository = Mockito.mock(IUserRepository.class);
        getByIdUseCase = new GetByIdUseCase(userRepository);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when id is null")
    public void execute_ShouldThrowIllegalArgumentException_WhenIdIsNull(){
        assertThrows(IllegalArgumentException.class, () -> getByIdUseCase.execute(null));
    }
}