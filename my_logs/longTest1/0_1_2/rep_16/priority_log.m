
% 2015-10-17 01:29:28

% my_logs\longTest1\0_1_2\rep_16\priority_log.m
scheduling_duration_us = 22400;

% schedule
schedule_f_t_n(:,:,1) = [5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 0, 5, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 0, 0, 5, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 5, 0, 0, 0; 0, 0, 0, 0];

% cost function results
vioSt = [0];
vioDl = [0];
vioNon = [3465];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [0];
vioLcy = [11075];
vioJit = [22075];
cost_vio = 329535;
cost_switches = 800;
cost_ch = 1950;
costTotal = 332285;

% priority
% 
% ############### Network 0 ##############
% F0	|[0]5	|5	|5	|5	|5	|5	|5	|	|	|	|[10]	|	|	|	|	|	|	|	|5	|5	|[20]5	|5	|5	|5	|5	|5	|	|	|	|	|[30]	|	|	|	|	|	|	|5	|5	|5	|[40]5	|5	|5	|5	|5	|5	|5	|5	|5	|	|
% ############### Network 1 ##############
% F0	|[0]	|	|	|	|	|	|	|5	|5	|5	|[10]5	|5	|5	|5	|5	|5	|5	|5	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|
% ############### Network 2 ##############
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|5	|5	|5	|5	|[30]5	|5	|5	|5	|5	|5	|5	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|
% ############### Network 3 ##############
