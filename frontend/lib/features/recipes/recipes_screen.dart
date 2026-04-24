import 'package:flutter/material.dart';

class RecipesScreen extends StatelessWidget {
  const RecipesScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('레시피')),
      body: const Center(
        child: Text('레시피 추천 화면', style: TextStyle(fontSize: 24)),
      ),
    );
  }
}