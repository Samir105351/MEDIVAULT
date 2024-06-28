package com.samir.medivault.config;

import com.samir.medivault.dto.AuthenticationRequest;
import com.samir.medivault.dto.AuthenticationResponse;
import com.samir.medivault.dto.RegisterRequest;
import com.samir.medivault.dto.RegisterResponse;
import com.samir.medivault.entity.PatientInformation;
import com.samir.medivault.entity.User;
import com.samir.medivault.enums.Role;
import com.samir.medivault.enums.Status;
import com.samir.medivault.repository.PatientInformationRepository;
import com.samir.medivault.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PatientInformationRepository patientInformationRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public RegisterResponse register(RegisterRequest request) {
        PatientInformation patientInformation = PatientInformation
                .builder()
                .patientGender(request.patientGender())
                .patientAge(request.patientAge())
                .patientName(STR."\{request.firstName()} \{request.lastName()}")
                .build();
        PatientInformation savedPatientInformation = patientInformationRepository.save(patientInformation);

        User user = User
                .builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .patientInformation(savedPatientInformation)
                .build();
        userRepository.save(user);

        return new RegisterResponse(Status.SUCCESSFUL, "Successfully registered user information");
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        User user = userRepository.findByEmail(request.email()).orElseThrow(
                () -> new UsernameNotFoundException(STR."Username not found with email: \{request.email()}")
        );

        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(Status.SUCCESSFUL, jwtToken);
    }
}
