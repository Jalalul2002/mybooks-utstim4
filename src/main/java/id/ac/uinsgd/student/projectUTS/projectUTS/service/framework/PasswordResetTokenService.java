package id.ac.uinsgd.student.projectUTS.projectUTS.service.framework;

import id.ac.uinsgd.student.projectUTS.projectUTS.entity.PasswordResetToken;

public interface PasswordResetTokenService {
    PasswordResetToken findByToken(String token);

    PasswordResetToken save(PasswordResetToken passwordResetToken);
}
