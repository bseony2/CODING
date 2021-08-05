def solution(s):
    answer = 9876543210
    if len(s) < 3:
        return len(s)

    for token_length in range(1, (len(s) // 2) + 1):
        compress_s = ""
        split_s = [s[i : i + token_length] for i in range(0, len(s), token_length)]
        old_token = ''
        token_count = 1
        for token in split_s:
            if old_token != token:
                if token_count > 1:
                    compress_s += str(token_count)
                compress_s += old_token
                old_token = token
                token_count = 1
            else:
                token_count += 1
        if token_count > 1:
            compress_s += str(token_count)
        compress_s += old_token
        answer = min(answer, len(compress_s))

    return answer
