import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'shared/widgets/main_scaffold.dart';

void main() {
  runApp(
    // ProviderScope: Riverpod의 "공용 창고"를 앱 전체에서 쓸 수 있게 감싸는 역할
    // 이걸 최상위에 두지 않으면 Riverpod이 동작 안 해요
    const ProviderScope(
      child: FridgeApp(),
    ),
  );
}

class FridgeApp extends StatelessWidget {
  const FridgeApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'AI 냉장고',
      debugShowCheckedModeBanner: false, // 우측 상단 DEBUG 배너 숨김
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.green),
        useMaterial3: true,
      ),
      home: const MainScaffold(),
    );
  }
}