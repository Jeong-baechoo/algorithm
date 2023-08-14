#include <iostream>
#include <vector>
#include <ctime>
#include <sstream>
#include <cstring> // strptime을 사용하기 위한 헤더

int main() {
    // 현재 날짜 입력 받기
    std::string currentDateStr;
    std::cin >> currentDateStr;

    struct tm currentDate = {};
    const char* format = "%Y-%m-%d";
    strptime(currentDateStr.c_str(), format, &currentDate);

    int n;
    std::cin >> n;

    int usableGifticons = 0;

    for (int i = 0; i < n; ++i) {
        std::string expirationDateStr;
        std::cin >> expirationDateStr;

        struct tm expirationDate = {};
        strptime(expirationDateStr.c_str(), format, &expirationDate);

        if (expirationDate.tm_year + 1900 > currentDate.tm_year + 1900 ||
            (expirationDate.tm_year + 1900 == currentDate.tm_year + 1900 && expirationDate.tm_mon + 1 > currentDate.tm_mon + 1) ||
            (expirationDate.tm_year + 1900 == currentDate.tm_year + 1900 && expirationDate.tm_mon + 1 == currentDate.tm_mon + 1 && expirationDate.tm_mday >= currentDate.tm_mday)) {
            usableGifticons++;
        }
    }

    std::cout << usableGifticons << std::endl;

    return 0;
}
