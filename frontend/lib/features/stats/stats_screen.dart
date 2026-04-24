import 'package:flutter/material.dart';

class StatsScreen extends StatelessWidget {
  const StatsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('대시보드')),
      body: const Center(
        child: Text('소비 패턴 분석 화면', style: TextStyle(fontSize: 24)),
      ),
    );
  }
}