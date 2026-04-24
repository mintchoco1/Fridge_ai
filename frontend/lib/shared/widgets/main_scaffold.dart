import 'package:flutter/material.dart';
import '../../features/ingredients/ingredients_screen.dart';
import '../../features/recipes/recipes_screen.dart';
import '../../features/notifications/notifications_screen.dart';
import '../../features/stats/stats_screen.dart';

class MainScaffold extends StatefulWidget {
  const MainScaffold({super.key});

  @override
  State<MainScaffold> createState() => _MainScaffoldState();
}

class _MainScaffoldState extends State<MainScaffold> {
  // 현재 선택된 탭 인덱스 (0: 재료, 1: 레시피, 2: 알림, 3: 대시보드)
  int _currentIndex = 0;

  // 탭에 해당하는 화면들을 리스트로 관리
  final List<Widget> _screens = const [
    IngredientsScreen(),
    RecipesScreen(),
    NotificationsScreen(),
    StatsScreen(),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // 현재 인덱스에 해당하는 화면을 보여줌
      body: _screens[_currentIndex],

      // 하단 탭바
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _currentIndex,
        onTap: (index) {
          setState(() {
            _currentIndex = index;
          });
        },
        type: BottomNavigationBarType.fixed, // 탭 4개 이상일 때 필수
        selectedItemColor: Colors.green,
        unselectedItemColor: Colors.grey,
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.kitchen),
            label: '재료',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.restaurant_menu),
            label: '레시피',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.notifications),
            label: '알림',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.bar_chart),
            label: '대시보드',
          ),
        ],
      ),
    );
  }
}